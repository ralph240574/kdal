package com.weather.android.kdal

import com.weather.android.kdal.QueryParameter.*

enum class Product(val productName: String, val queryParameter: Set<QueryParameter> = setOf(LANGUAGE, UNITS)) {

    VT1_ALERTS("vt1alerts", setOf(LANGUAGE)),
    VT1_CONTENT_MODE("vt1contentMode", setOf()), //this will not work alone in aggregate call
    VT1_CURRENT_TIDES("vt1currentTides"),
    VT1_IDX_BREATHING_DAYPART("vt1idxBreathingDaypart", setOf(LANGUAGE)),
    VT1_IDX_POLLEN_DAYPART("vt1idxPollenDaypart", setOf(LANGUAGE)),
    VT1_LIGHTNING("vt1lightning", setOf(LANGUAGE)),
    VT1_NOWCAST("Vt1nowcast"),
    VT1_POLLENOBS("Vt1pollenobs", setOf(LANGUAGE)),
    VT1_PRECIPITATION("vt1precipitation"),
    VT1_RUNWEATHERHOURLY("vt1runweatherhourly", setOf()),
    VT1_WWIR("vt1wwir"),
    V2_FCSTINTRADAY3("V2fcstintraday3"),
    V2_GLOBALAIR("v2globalair", setOf(LANGUAGE)),
    V2_IDX_BREATHING_DAYPART15("V2idxBreathingDaypart15", setOf(LANGUAGE)),
    V2_IDX_DRIVE_CURRENT("V2idxDriveCurrent", setOf(LANGUAGE)),
    V2_IDX_POLLEN_DAYPART_15("v2idxPollenDaypart15", setOf(LANGUAGE)),
    V2_IDX_RUN_DAY_PART15("v2idxRunDaypart15", setOf(LANGUAGE)),
    V2_IDX_MOSQUITO_DAILY_3("v2idxMosquitoDaily3", setOf(LANGUAGE)),
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

//    v3-location-search, this will not work as a standalone in the agg call


    override fun toString(): String = productName


    companion object {

        fun asString(products: Set<Product>): String {
            return products.joinToString(separator = ";")
        }

    }

}




