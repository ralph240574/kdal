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
        val cacheDir: File,
        val baseUrl: String = BASE_URL,
        val cacheSizeInByte: Long = CACHE_SIZE_IN_BYTE,
        val maxCacheAgeInSec: Int = MAX_CACHE_AGE_IN_SEC,
        val loggingEnabled: Boolean = false) {


    enum class Mode {
        OFFLINE, // only read from local cache
        CACHE_FIRST, // use cache if available and valid, otherwise use network
        CACHE_AND_NETWORK, // get cache first then network
        NETWORK_FIRST, //
        NETWORK_ONLY // do not use cache use only network
    }

    val repo: V3AggInterface = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(moshiConverterFactory())
//                .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient(loggingEnabled))
            .build().create(V3AggInterface::class.java)

    private fun okHttpClient(loggingEnabled: Boolean): OkHttpClient {
        val builder =
                OkHttpClient.Builder()
                        .cache(Cache(File(cacheDir.getAbsolutePath()), cacheSizeInByte))
                        .addInterceptor(ApiKeyInterceptor(apiKey))
                        .addNetworkInterceptor(RewriteResponse(maxCacheAgeInSec))
        if (loggingEnabled) {
            builder.addNetworkInterceptor(LOGGING)
        }
        return builder.build()
    }


    private fun moshiConverterFactory() =
            MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())


    companion object {

        val BASE_URL = "https://api.weather.com"

        val MAX_CACHE_AGE_IN_SEC = 4 * 60 * 60

        val CACHE_SIZE_IN_BYTE = 512 * 1024L
    }

    @Volatile
    var mode: Mode = Mode.CACHE_FIRST

    @Volatile
    var units: Units = Units.ENGLISH

    @Volatile
    var locale: Locale = Locale.US

    @Volatile
    var latLng: LatLng = LatLng(33.91, -84.34)


    /**
     * Returns Observable with 1 or 2 items, the first one will be the cached data,
     * the second one data from the network, or error if no network and no cache
     */
    fun getV3Agg(products: Set<Product>,
                 latLng: LatLng = this.latLng,
                 maxAgeResponseCache: Int = MAX_CACHE_AGE_IN_SEC,
                 setMode: Mode = mode)
            : Observable<V3Agg> {

        val fromCache = getV3AggFromCache(products, latLng = latLng, maxAgeResponse = maxAgeResponseCache)

        val fromNetwork = getV3AggFromNetwork(products, latLng = latLng)

        val observable: Observable<V3Agg> =
                when (setMode) {
                    Mode.OFFLINE -> fromCache.toObservable()
                    Mode.CACHE_FIRST -> fromCache.onErrorResumeNext(fromNetwork).toObservable()
                    Mode.CACHE_AND_NETWORK -> Observable.concat(fromCache.toObservable().onErrorResumeNext(Observable.empty()), fromNetwork.toObservable())
                    Mode.NETWORK_FIRST -> Observable.concat(fromNetwork.toObservable().onErrorResumeNext(Observable.empty()), fromCache.toObservable())
                    Mode.NETWORK_ONLY -> fromNetwork.toObservable()
                }

        return observable

    }

    /**
     * Returns Single with data from network
     */
    fun getV3AggFromNetwork(
            products: Set<Product>,
            latLng: LatLng = this.latLng)
            : Single<V3Agg> {

        val queryParameters: Set<QueryParameter> = getQueryParameters(products)

        return repo.getV3AggFromNetwork(
                asString(products),
                getLanguageParameter(queryParameters),
                getPollenDate(queryParameters),
                getScaleParameter(queryParameters),
                latLng.toQueryParameter(),
                getUnitsParameter(queryParameters))
    }


    /**
     *  This will return the cache if it is less than maxAgeResponse old, otherwise it will throw an error
     */
    fun getV3AggFromCache(products: Set<Product>,
                          latLng: LatLng = this.latLng,
                          maxAgeResponse: Int = MAX_CACHE_AGE_IN_SEC)
            : Single<V3Agg> {

        val queryParameters: Set<QueryParameter> = getQueryParameters(products)

        val dynamicHeaderMap = mapOf(Pair("Cache-Control", "max-age=${maxAgeResponse}, only-if-cached"))

        return repo.getV3AggFromCache(dynamicHeaderMap,
                asString(products),
                getLanguageParameter(queryParameters),
                getPollenDate(queryParameters),
                getScaleParameter(queryParameters),
                latLng.toQueryParameter(),
                getUnitsParameter(queryParameters))
    }

    /**
     * This will calculate the required set of query parameters based on the selected Products
     */
    private fun getQueryParameters(products: Set<Product>): Set<QueryParameter> {
        val queryParameters: Set<QueryParameter> = products.fold(setOf()) { total, next -> total.plus(next.queryParameter) }
        return queryParameters
    }

    //TODO check what to use
    private fun getScaleParameter(queryParameters: Set<QueryParameter>): String? =
            if (queryParameters.contains(QueryParameter.SCALE)) "EPA" else null

    //TODO check what date to use
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
