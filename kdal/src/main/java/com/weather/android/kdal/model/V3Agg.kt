package com.weather.android.kdal.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi


@JsonClass(generateAdapter = true)
data class V3Agg(

        val id: String, // 33.92,-84.34

        val requestTime: String = "",

        val vt1alerts: Vt1alerts?,

        val vt1contentMode: Vt1contentMode?,

        val vt1currentTides: Vt1currentTides?,

        val vt1lightning: Vt1lightning?,

        val vt1nowcast: Vt1nowcast?,

        val vt1pollenobs: Vt1pollenobs?,

        val vt1precipitation: Vt1precipitation?,

        val vt1wwir: Vt1wwir?,

        val v2idxDrySkinDaypart15: V2idxDrySkinDaypart?,

        val v2fcstintraday3: V2fcstintraday3?,

        val v2idxBreathingDaypart15: V2idxBreathingDaypart?,

        val v2idxDriveCurrent: V2idxDriveCurrent?,

        val v2idxRunDaypart15: V2idxRunDaypart?,

        val v2idxRunHourly24: V2idxRunHourly?,

        val v2idxPollenDaypart15: V2idxPollenDaypart?,

        val v2idxMosquitoDaily3: V2idxMosquitoDaily?,

        val v2idxMosquitoDaily7: V2idxMosquitoDaily?,

        val v3alertsDetail: V3alertsDetail?,

        val v3alertsHeadlines: V3alertsHeadlines?,

        @Json(name = "v3-wx-conditions-historical-dailysummary-30day")
        val v3WxConditionsHistoricalDailysummary30day: V3WxConditionsHistoricalDailysummary?,

        @Json(name = "v3-wx-conditions-historical-hourly-1day")
        val v3WxConditionsHistoricalHourly1day: V3WxConditionsHistoricalHourly?,

        @Json(name = "v3-wx-forecast-daily-15day")
        val v3WxForecastDaily15day: V3WxForecastDaily?,

        @Json(name = "v3-wx-forecast-hourly-2day")
        val v3WxForecastHourly2day: V3WxForecastHourly?,

        @Json(name = "v3-wx-forecast-hourly-10day")
        val v3WxForecastHourly10day: V3WxForecastHourly?,

        @Json(name = "v3-wx-globalAirQuality")
        val v3WxGlobalAirQuality: V3WxGlobalAirQuality?,

        @Json(name = "v3-wx-indices-flux-daily-15day")
        val v3WxIndicesFluxDaily15day: V3WxIndicesFluxDaily?,

        @Json(name = "v3-wx-indices-pollen-historical-1day")
        val v3WxIndicesPollenHistorical1day: V3WxIndicesPollenHistorical?,

        @Json(name = "v3-wx-observations-current")
        val v3WxObservationsCurrent: V3WxObservationsCurrent?,

        @Json(name = "v3-wx-skiconditions")
        val v3WxSkiconditions: V3WxSkiconditions?,

        @Json(name = "v3-location-point")
        val v3LocationPoint: V3LocationPoint?

) {


    //this will ensure that all Lists with non nullable types have no null value
    fun validate() {

        v2fcstintraday3?.validate()
        v2idxBreathingDaypart15?.validate()
        v2idxPollenDaypart15?.validate()


        v3alertsDetail?.validate()
        v3alertsHeadlines?.validate()

        v3WxForecastDaily15day?.validate()
        v3WxForecastDaily15day?.validate()

        v3WxForecastHourly2day?.validate()
        v3WxForecastHourly10day?.validate()

        v3WxIndicesFluxDaily15day?.validate()
        v3WxIndicesPollenHistorical1day?.validate()

        v3WxConditionsHistoricalDailysummary30day?.validate()
        v3WxConditionsHistoricalHourly1day?.validate()

        vt1precipitation?.validate()
        vt1lightning?.validate()

    }


    fun fromFile(path: String): V3Agg? {

        val moshi = Moshi.Builder().build()

        val jsonAdapter = moshi.adapter(V3Agg::class.java)


        val jsonString = ""

        return jsonAdapter.fromJson(jsonString)
    }

}
