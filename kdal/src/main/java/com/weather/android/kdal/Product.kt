package com.weather.android.kdal


import com.weather.android.kdal.QueryParameter.*


enum class Product(val productName: String, val queryParameter: Set<QueryParameter> = setOf(LANGUAGE, UNITS)) {

    VT1_ALERTS("vt1alerts", setOf(LANGUAGE)),
    VT1_CONTENT_MODE("vt1contentMode", setOf()), //this will not work alone in aggregate call
    VT1_CURRENT_TIDES("vt1currentTides"),
    VT1_LIGHTNING("vt1lightning", setOf(LANGUAGE)),
    VT1_NOWCAST("vt1nowcast"),
    VT1_POLLENOBS("vt1pollenobs", setOf(LANGUAGE)),
    VT1_PRECIPITATION("vt1precipitation"),
    VT1_WWIR("vt1wwir"),
    V2_FCSTINTRADAY3("v2fcstintraday3"),
    V2_IDX_BREATHING_DAYPART15("v2idxBreathingDaypart15", setOf(LANGUAGE)),
    V2_IDX_DRY_SKIN_DAYPART15("v2idxDrySkinDaypart15", setOf(LANGUAGE)),
    V2_IDX_POLLEN_DAYPART_15("v2idxPollenDaypart15", setOf(LANGUAGE)),
    V2_IDX_RUN_DAY_PART15("v2idxRunDaypart15", setOf(LANGUAGE)),
    V2_IDX_RUN_HOURLY24("v2idxRunHourly24", setOf(LANGUAGE)),
    V2_IDX_MOSQUITO_DAILY_3("v2idxMosquitoDaily3", setOf(LANGUAGE)),
    V2_IDX_MOSQUITO_DAILY_7("v2idxMosquitoDaily7", setOf(LANGUAGE)),
    V3_ALERTS_DETAIL("v3alertsDetail", setOf(LANGUAGE, ALERT_ID)), // will only work with a product that uses geocode
    V3_ALERTS_HEADLINES("v3alertsHeadlines", setOf(LANGUAGE)),
    V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY("v3-wx-conditions-historical-dailysummary-30day"),
    V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY("v3-wx-conditions-historical-hourly-1day"),
    V3_WX_FORECAST_DAILY_15_DAY("v3-wx-forecast-daily-15day"),
    V3_WX_FORECAST_HOURLY_2_DAY("v3-wx-forecast-hourly-2day"),
    V3_WX_FORECAST_HOURLY_10_DAY("v3-wx-forecast-hourly-10day"),
    V3_WX_GLOBAL_AIR_QUALITY("v3-wx-globalAirQuality", setOf(LANGUAGE, SCALE)),
    V3_WX_INDICES_FLUX_DAILY_15_DAY("v3-wx-indices-flux-daily-15day", setOf(UNITS)),
    V3_WX_INDICES_POLLEN_HISTORICAL_1DAY("v3-wx-indices-pollen-historical-1day", setOf(LANGUAGE, DATE_YYYYMMdd)),
    V3_WX_OBSERVATIONS_CURRENT("v3-wx-observations-current"),
    V3_WX_SKICONDITIONS("v3-wx-skiconditions"),
    V3_LOCATION_POINT("v3-location-point", setOf(LANGUAGE));


//    V2idxRunHourly-location-search, this will not work as a standalone in the agg call


    override fun toString(): String = productName


    companion object {

        fun asString(products: Set<Product>): String {
            return products.joinToString(separator = ";")
        }

    }


}





