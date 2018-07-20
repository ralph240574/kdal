package com.weather.android.kdal.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.weather.android.kdal.Product

//TODO datestamp of retrieval

data class V3Agg(

        val id: String, // 33.92,-84.34

        val vt1alerts: Vt1alerts?,

        val vt1contentMode: Vt1contentMode?,

        val vt1currentTides: Vt1currentTides?,

        val vt1dailyforecast: Vt1dailyforecast?,

        val vt1idxBreathingDaypart: Vt1idxBreathingDaypart?,

        val vt1idxPollenDaypart: Vt1idxPollenDaypart?,

        val vt1lightning: Vt1lightning?,

        @SerializedName(value = "Vt1nowcast")
        @Json(name = "Vt1nowcast")
        val vt1nowcast: Vt1nowcast?,

        val vt1observation: Vt1observation?,

        @SerializedName(value = "Vt1pollenobs")
        @Json(name = "Vt1pollenobs")
        val vt1pollenobs: Vt1pollenobs?,

        val vt1precipitation: Vt1precipitation?,

        val vt1runweatherhourly: Vt1runweatherhourly?,

        val vt1wwir: Vt1wwir?,

        @SerializedName(value = "V2fcstintraday3")
        @Json(name = "V2fcstintraday3")
        val v2fcstintraday3: V2fcstintraday3?,

        val v2globalair: V2globalair?,

        @SerializedName(value = "V2idxBreathingDaypart15")
        @Json(name = "V2idxBreathingDaypart15")
        val v2idxBreathingDaypart15: V2idxBreathingDaypart15?,

        @SerializedName(value = "V2idxDriveCurrent")
        @Json(name = "V2idxDriveCurrent")
        val v2idxDriveCurrent: V2idxDriveCurrent?,

        val v2idxRunDaypart15: V2idxRunDaypart15?,

        val v2idxPollenDaypart15: V2idxPollenDaypart15?,

        val v3alertsDetail: V3alertsDetail?,

        val v3alertsHeadlines: V3alertsHeadlines?,

        @SerializedName(value = "v3-wx-conditions-historical-dailysummary-30day")
        @Json(name = "v3-wx-conditions-historical-dailysummary-30day")
        val v3WxConditionsHistoricalDailysummary30day: V3WxConditionsHistoricalDailysummary?,

        @SerializedName(value = "v3-wx-conditions-historical-hourly-1day")
        @Json(name = "v3-wx-conditions-historical-hourly-1day")
        val v3WxConditionsHistoricalHourly1day: V3WxConditionsHistoricalHourly?,

        @SerializedName(value = "v3-wx-forecast-daily-15day")
        @Json(name = "v3-wx-forecast-daily-15day")
        val v3WxForecastDaily15day: V3WxForecastDaily?,

        @SerializedName(value = "v3-wx-forecast-hourly-2day")
        @Json(name = "v3-wx-forecast-hourly-2day")
        val V3WxForecastHourly2day: V3WxForecastHourly?,

        @SerializedName(value = "v3-wx-forecast-hourly-10day")
        @Json(name = "v3-wx-forecast-hourly-10day")
        val v3WxForecastHourly10day: V3WxForecastHourly?,

        @SerializedName(value = "v3-wx-globalAirQuality")
        @Json(name = "v3-wx-globalAirQuality")
        val v3WxGlobalAirQuality: V3WxGlobalAirQuality?,

        @SerializedName(value = "v3-wx-indices-flux-daily-15day")
        @Json(name = "v3-wx-indices-flux-daily-15day")
        val v3WxIndicesFluxDaily15day: V3WxIndicesFluxDaily15day?,

        @SerializedName(value = "v3-wx-indices-pollen-historical-1day")
        @Json(name = "v3-wx-indices-pollen-historical-1day")
        val v3WxIndicesPollenHistorical1day: V3WxIndicesPollenHistorical?,

        @SerializedName(value = "v3-wx-observations-current")
        @Json(name = "v3-wx-observations-current")
        val v3WxObservationsCurrent: V3WxObservationsCurrent?,

        @SerializedName(value = "v3-wx-skiconditions")
        @Json(name = "v3-wx-skiconditions")
        val v3WxSkiconditions: V3WxSkiconditions?

)

fun contains(prod: Product): Boolean {
    return false
}

