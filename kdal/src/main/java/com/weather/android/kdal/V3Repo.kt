package com.weather.android.kdal

import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.model.V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE
import io.reactivex.Observable
import java.util.*

enum class Units(val unit: Char) {

    ENGLISH('e'), METRIC('m'), HYBRID('h');

    override fun toString(): String = unit.toString()

}

const val BASE_URL = "https://api.weather.com"

const val MAX_CACHE_AGE_IN_SEC = 4 * 60 * 60

const val CACHE_SIZE_IN_BYTE = 512 * 1024L

interface V3Repo {

    enum class Mode {
        OFFLINE, // only read from local cache
        CACHE_FIRST, // use cache if available and valid, otherwise use network
        CACHE_AND_NETWORK, // get cache first then network
        NETWORK_FIRST, //
        NETWORK_ONLY // do not use cache use only network
    }


    var latLng: LatLng

    var maxCacheAgeInSec: Int

    var mode: Mode

    var units: Units

    var locale: Locale

    var v3GlobalAirScaleParameterValue: SCALE_PARAMETER_VALUE


    /**
     * Returns Observable with 1 or 2 items, the first one will be the cached data,
     * the second one data from the network, or error if no network and no cache
     */
    fun getV3Agg(products: Set<Product>,
                 latLng: LatLng = this.latLng,
                 maxAgeResponseCache: Int = this.maxCacheAgeInSec,
                 mode: Mode = this.mode,
                 units: Units = this.units,
                 locale: Locale = this.locale,
                 globalAirScaleParameter: SCALE_PARAMETER_VALUE = this.v3GlobalAirScaleParameterValue)
            : Observable<V3Agg>


}