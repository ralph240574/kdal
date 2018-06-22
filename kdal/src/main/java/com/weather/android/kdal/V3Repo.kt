package com.weather.android.kdal

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.weather.android.kdal.Product.Companion.asString
import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.network.ApiKeyInterceptor
import com.weather.android.kdal.network.LOGGING
import com.weather.android.kdal.network.RewriteResponse
import com.weather.android.kdal.network.V3AggInterface
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

enum class Units(val unit: Char) {

    ENGLISH('e'), METERIC('m'), HYBRID('h');

    override fun toString(): String = unit.toString()
}

class V3Repo constructor(
        val apiKey: String,
        val cacheDir: File = File("./cache"),
        val baseUrl: String = BASE_URL,
        val cacheSizeInByte: Long = CACHE_SIZE_IN_BYTE,
        val maxCacheAgeInSec: Long = MAX_CACHE_AGE_IN_SEC,
        val loggingEnabled: Boolean = false) {

    val repo: V3AggInterface = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(moshiConverterFactory())
//                .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                    .cache(Cache(File(cacheDir.getAbsolutePath()), cacheSizeInByte))
                    .addInterceptor(ApiKeyInterceptor(apiKey))
//                    .addInterceptor(LOGGING)
                    .addNetworkInterceptor(LOGGING)
                    .addNetworkInterceptor(RewriteResponse(maxCacheAgeInSec))
                    .build())
            .build().create(V3AggInterface::class.java)

    private fun moshiConverterFactory() =
            MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())


    companion object {

        val BASE_URL = "https://api.weather.com"

        val MAX_CACHE_AGE_IN_SEC = (4 * 60 * 60).toLong()

        val CACHE_SIZE_IN_BYTE = (512 * 1024).toLong()
    }

    var units: Units = Units.ENGLISH

    var locale: Locale = Locale.US

    var latLng: LatLng = LatLng(33.91, -84.34)


    // try Maybe??

    fun getV3Agg(products: Set<Product>,
                 latLng: LatLng = this.latLng): Observable<V3Agg> {

        val fromCache = getV3AggFromCache(
                products,
                latLng = latLng,
                maxCacheAgeInSec = 60)


        val fromNetwork = getV3AggFromNetwork(products,
                latLng = latLng)

        return Single.mergeDelayError(fromCache, fromNetwork).toObservable()
//        return Observable.concat(single1.toObservable(), single2.toObservable())

    }

    fun getV3AggFromNetwork(products: Set<Product>,
                            latLng: LatLng = this.latLng): Single<V3Agg> {

        val queryParameters: Set<QueryParameter> = getQueryParameters(products)

        return repo.getV3AggFromNetwork(
                asString(products),
                getLanguageParameter(queryParameters),
                getPollenDate(queryParameters),
                getScaleParameter(queryParameters),
                latLng.toQueryParameter(),
                getUnitsParameter(queryParameters))
    }


    // this will return the cache first if it is less than machCacheAgeInSec old, otherwise it will make a network request
    fun getV3AggFromCache(products: Set<Product>,
                          latLng: LatLng = this.latLng,
                          maxCacheAgeInSec: Long = 3600)
            : Single<V3Agg> {

        val queryParameters: Set<QueryParameter> = getQueryParameters(products)

        return repo.getV3AggFromCache(mapOf(Pair("Cache-Control", "max-age=${maxCacheAgeInSec.toString()}, only-if-cached")),
                asString(products),
                getLanguageParameter(queryParameters),
                getPollenDate(queryParameters),
                getScaleParameter(queryParameters),
                latLng.toQueryParameter(),
                getUnitsParameter(queryParameters))
    }

    private fun getQueryParameters(products: Set<Product>): Set<QueryParameter> {
        val queryParameters: Set<QueryParameter> = products.fold(setOf()) { total, next -> total.plus(next.queryParameter) }
        return queryParameters
    }

    private fun getScaleParameter(queryParameters: Set<QueryParameter>): String? =
            if (queryParameters.contains(QueryParameter.SCALE)) "EPA" else null

    private fun getPollenDate(queryParameters: Set<QueryParameter>): String? =
            if (queryParameters.contains(QueryParameter.DATE_YYYYMMdd)) getYesterdaysDate() else null

    private fun getYesterdaysDate(): String {
        val cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1)
        return SimpleDateFormat("yyyyMMdd", Locale.US).format(cal.time)
    }


    private fun getLanguageParameter(queryParameters: Set<QueryParameter>) =
            if (queryParameters.contains(QueryParameter.LANGUAGE)) getLocaleString(locale) else null


    private fun getUnitsParameter(queryParameters: Set<QueryParameter>) =
            if (queryParameters.contains(QueryParameter.UNITS)) units else null

    fun getLocaleString(locale: Locale): String {
        return if ("" != locale.country) locale.language + "-" + locale.country else locale.language
    }


}
