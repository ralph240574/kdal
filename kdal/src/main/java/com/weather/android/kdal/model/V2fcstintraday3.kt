package com.weather.android.kdal.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class V2fcstintraday3(
        val metadata: Metadata,
        val forecasts: List<Forecast>
) {
    data class Forecast(
            @SerializedName(value = "class")
            @Json(name = "class")
            val classX: String, // fod_long_range_intraday
            @SerializedName(value = "expire_time_gmt")
            @Json(name = "expire_time_gmt")
            val expireTimeGmt: Long, // 1529688903
            @SerializedName(value = "fcst_valid")
            @Json(name = "fcst_valid")
            val fcstValid: Int, // 1529971200
            @SerializedName(value = "fcst_valid_local")
            @Json(name = "fcst_valid_local")
            val fcstValidLocal: String, // 2018-06-25T19:00:00-0500
            val num: Int, // 14
            val temp: Int, // 80
            val pop: Int, // 8
            @SerializedName(value = "icon_extd")
            @Json(name = "icon_extd")
            val iconExtd: Int, // 2700
            @SerializedName(value = "icon_code")
            @Json(name = "icon_code")
            val iconCode: Int, // 27
            val dow: String, // Monday
            @SerializedName(value = "daypart_name")
            @Json(name = "daypart_name")
            val daypartName: String, // Evening
            @SerializedName(value = "phrase_12char")
            @Json(name = "phrase_12char")
            val phrase12char: String, // M Cloudy
            @SerializedName(value = "phrase_22char")
            @Json(name = "phrase_22char")
            val phrase22char: String, // Mostly Cloudy
            @SerializedName(value = "phrase_32char")
            @Json(name = "phrase_32char")
            val phrase32char: String, // Mostly Cloudy
            @SerializedName(value = "subphrase_pt1")
            @Json(name = "subphrase_pt1")
            val subphrasePt1: String, // Mostly
            @SerializedName(value = "subphrase_pt2")
            @Json(name = "subphrase_pt2")
            val subphrasePt2: String, // Cloudy
            @SerializedName(value = "subphrase_pt3")
            @Json(name = "subphrase_pt3")
            val subphrasePt3: String,
            @SerializedName(value = "precip_type")
            @Json(name = "precip_type")
            val precipType: String, // rain
            val rh: Int, // 84
            val wspd: Int, // 12
            val wdir: Int, // 130
            @SerializedName(value = "wdir_cardinal")
            @Json(name = "wdir_cardinal")
            val wdirCardinal: String, // SE
            val clds: Int, // 66
            @SerializedName(value = "qualifier_code")
            @Json(name = "qualifier_code")
            val qualifierCode: Any?, // null
            val qualifier: Any? // null
    )

    data class Metadata(
            val language: String, // en-US
            @SerializedName(value = "transaction_id")
            @Json(name = "transaction_id")
            val transactionId: String, // 1529688381613:-1945012202
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val units: String, // e
            @SerializedName(value = "expire_time_gmt")
            @Json(name = "expire_time_gmt")
            val expireTimeGmt: Long, // 1529688903
            @SerializedName(value = "status_code")
            @Json(name = "status_code")
            val statusCode: Int // 200
    )
}
