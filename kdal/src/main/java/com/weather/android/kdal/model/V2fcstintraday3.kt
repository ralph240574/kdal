package com.weather.android.kdal.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList

@JsonClass(generateAdapter = true)
data class V2fcstintraday3(
        val metadata: Metadata,
        val forecasts: List<Forecast>
) {
    @JsonClass(generateAdapter = true)
    data class Forecast(
            @Json(name = "class")
            val classX: String, // fod_long_range_intraday
            @Json(name = "expire_time_gmt")
            val expireTimeGmt: Long, // 1529688903
            @Json(name = "fcst_valid")
            val fcstValid: Int, // 1529971200
            @Json(name = "fcst_valid_local")
            val fcstValidLocal: String, // 2018-06-25T19:00:00-0500
            val num: Int, // 14
            val temp: Int, // 80
            val pop: Int, // 8
            @Json(name = "icon_extd")
            val iconExtd: Int, // 2700
            @Json(name = "icon_code")
            val iconCode: Int, // 27
            val dow: String, // Monday
            @Json(name = "daypart_name")
            val daypartName: String, // Evening
            @Json(name = "phrase_12char")
            val phrase12char: String, // M Cloudy
            @Json(name = "phrase_22char")
            val phrase22char: String, // Mostly Cloudy
            @Json(name = "phrase_32char")
            val phrase32char: String, // Mostly Cloudy
            @Json(name = "subphrase_pt1")
            val subphrasePt1: String, // Mostly
            @Json(name = "subphrase_pt2")
            val subphrasePt2: String, // Cloudy
            @Json(name = "subphrase_pt3")
            val subphrasePt3: String,
            @Json(name = "precip_type")
            val precipType: String, // rain
            val rh: Int, // 84
            val wspd: Int, // 12
            val wdir: Int, // 130
            @Json(name = "wdir_cardinal")
            val wdirCardinal: String, // SE
            val clds: Int, // 66
            @Json(name = "qualifier_code")
            val qualifierCode: Any?, // null
            val qualifier: Any? // null
    )

    @JsonClass(generateAdapter = true)
    data class Metadata(
            val language: String, // en-US
            @Json(name = "transaction_id")
            val transactionId: String, // 1529688381613:-1945012202
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val units: String, // e
            @Json(name = "expire_time_gmt")
            val expireTimeGmt: Long, // 1529688903
            @Json(name = "status_code")
            val statusCode: Int // 200
    )

    fun validate() {
        forecasts.validateNoNullsInList()
    }

}
