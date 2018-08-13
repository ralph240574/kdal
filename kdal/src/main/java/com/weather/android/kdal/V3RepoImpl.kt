package com.weather.android.kdal

import android.util.Log
import com.squareup.moshi.Moshi
import com.weather.android.kdal.Product.Companion.asString
import com.weather.android.kdal.V3Repo.Mode.*
import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.model.V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE
import com.weather.android.kdal.model.V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.EPA
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


class V3RepoImpl constructor(
        val apiKey: String,
        val cacheDir: File,
        baseUrl: String = BASE_URL,
        val cacheSizeInByte: Long = CACHE_SIZE_IN_BYTE,
        override var maxCacheAgeInSec: Int = MAX_CACHE_AGE_IN_SEC,
        loggingEnabled: Boolean = false) : V3Repo {


    private val repo: V3AggInterface = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(moshiConverterFactory())
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
            MoshiConverterFactory.create(Moshi.Builder().build())

    // this will use kotlin-reflection, works fine, but adds 2.5 mb
//    private fun moshiConverterFactory() =
//            MoshiConverterFactory.create(Moshi.Builder().add(
//                    KotlinJsonAdapterFactory()
//            ).build())


    companion object {

        const val TAG = "V3Repo"


        @JvmStatic
        fun newV3Repo(apiKey: String, cacheDir: File, baseUrl: String, logging: Boolean): V3Repo {
            return V3RepoImpl(apiKey, cacheDir, baseUrl, loggingEnabled = logging)
        }


        /**
         * utility for Testing
         */
        @JvmStatic
        fun getV3AggFromFile(path: String): V3Agg? {

            val moshi = Moshi.Builder().build()

            val jsonAdapter = moshi.adapter(V3Agg::class.java)

            val jsonString = File(path).readText()
            return jsonAdapter.fromJson(jsonString)
        }

    }


    @Volatile
    override var mode: V3Repo.Mode = V3Repo.Mode.CACHE_FIRST

    @Volatile
    override var units: Units = Units.ENGLISH

    @Volatile
    override var v3GlobalAirScaleParameterValue = EPA

    @Volatile
    override var locale: Locale = Locale.US

    @Volatile
    override var latLng: LatLng = LatLng(33.91, -84.34)


    /**
     * Returns Observable with 1 or 2 items, the first one will be the cached data,
     * the second one data from the network, or error if no network and no cache
     */
    override fun getV3Agg(products: Set<Product>,
                          latLng: LatLng,
                          maxAgeResponseCache: Int,
                          mode: V3Repo.Mode,
                          units: Units,
                          locale: Locale,
                          globalAirScaleParameter: SCALE_PARAMETER_VALUE
    )
            : Observable<V3Agg> {

        val fromCache = getV3AggFromCache(products, latLng = latLng, maxAgeResponseInSec = maxAgeResponseCache)

        val fromNetwork = getV3AggFromNetwork(products, latLng = latLng)

        return when (mode) {
            OFFLINE -> fromCache.toObservable()
            CACHE_FIRST -> fromCache.onErrorResumeNext(fromNetwork).toObservable()
            CACHE_AND_NETWORK -> Observable.concat(fromCache.toObservable().onErrorResumeNext(Observable.empty()), fromNetwork.toObservable())
            NETWORK_FIRST -> fromNetwork.toObservable().onErrorResumeNext(fromCache.toObservable())
            NETWORK_ONLY -> fromNetwork.toObservable()
        }

    }


    /**
     * Returns Single with data from network
     */
    private fun getV3AggFromNetwork(
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
                .doOnSuccess({
                    it.validate()
                })
                .doOnError { t: Throwable ->
                    Log.e(TAG, t.toString(), t)
                }
    }


    /**
     *  This will return the cache if it is less than maxAgeResponse old, otherwise it will throw an error
     */
    private fun getV3AggFromCache(products: Set<Product>,
                                  latLng: LatLng = this.latLng,
                                  maxAgeResponseInSec: Int = MAX_CACHE_AGE_IN_SEC)
            : Single<V3Agg> {

        val queryParameters: Set<QueryParameter> = getQueryParameters(products)

        val dynamicHeaderMap = mapOf(Pair("Cache-Control", "max-age=${maxAgeResponseInSec}, only-if-cached"))

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

    private fun getScaleParameter(queryParameters: Set<QueryParameter>): String? =
            if (queryParameters.contains(QueryParameter.SCALE)) v3GlobalAirScaleParameterValue.toString() else null

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

    private fun getLocaleString(locale: Locale): String {
        return if ("" != locale.country) locale.language + "-" + locale.country else locale.language
    }

}