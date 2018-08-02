package com.weather.android.kdal.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V2globalair(
        val metadata: Metadata,
        val globalairquality: List<Globalairquality>
) {
    data class Metadata(
            val language: String, // en-US
            @SerializedName(value = "transaction_id")
            @Json(name = "transaction_id")
            val transactionId: String, // 1529682829205:-1120402558
            val version: String, // 2
            val key: String, // u09tvnh3
            @SerializedName(value = "expire_time_gmt")
            @Json(name = "expire_time_gmt")
            val expireTimeGmt: Long, // 1529683129
            @SerializedName(value = "status_code")
            @Json(name = "status_code")
            val statusCode: Int // 200
    )

    data class Globalairquality(
            @SerializedName(value = "class")
            @Json(name = "class")
            val classX: String, // globalairquality
            @SerializedName(value = "area_id")
            @Json(name = "area_id")
            val areaId: String, // u09tvnh3
            @SerializedName(value = "area_name")
            @Json(name = "area_name")
            val areaName: String, // STA-FR04071
            @SerializedName(value = "admin_level_1")
            @Json(name = "admin_level_1")
            val adminLevel1: String, // STA-FR04071
            @SerializedName(value = "country_cd")
            @Json(name = "country_cd")
            val countryCd: String, // FR
            val latitude: Double, // 48.856388
            val longitude: Double, // 2.335278
            val source: String?, // European Environment Agency
            @SerializedName(value = "rpt_dt")
            @Json(name = "rpt_dt")
            val rptDt: String?, // 2018-06-22T04:00:00Z
            @SerializedName(value = "valid_time_lap")
            @Json(name = "valid_time_lap")
            val validTimeLap: String?, // 2018-06-22T05:00+01:00
            @SerializedName(value = "process_tm_gmt")
            @Json(name = "process_tm_gmt")
            val processTmGmt: Int?, // 1529673193
            @SerializedName(value = "data_type")
            @Json(name = "data_type")
            val dataType: String?, // O
            @SerializedName(value = "air_quality_scale")
            @Json(name = "air_quality_scale")
            val airQualityScale: String?, // ATMO
            @SerializedName(value = "action_day_ind")
            @Json(name = "action_day_ind")
            val actionDayInd: String?, // N
            @SerializedName(value = "air_quality_cmnt")
            @Json(name = "air_quality_cmnt")
            val airQualityCmnt: Any?, // null
            @SerializedName(value = "air_quality_idx")
            @Json(name = "air_quality_idx")
            val airQualityIdx: Int?, // 26
            @SerializedName(value = "air_quality_cat")
            @Json(name = "air_quality_cat")
            val airQualityCat: String?, // Very Good
            @SerializedName(value = "air_quality_cat_idx")
            @Json(name = "air_quality_cat_idx")
            val airQualityCatIdx: Int?, // 1
            val pollutants: List<Pollutant?>?
    ) {
        data class Pollutant(
                val pollutant: String?, // NO2
                @SerializedName(value = "pollutant_amount")
                @Json(name = "pollutant_amount")
                val pollutantAmount: Double?, // 26
                @SerializedName(value = "pollutant_unit")
                @Json(name = "pollutant_unit")
                val pollutantUnit: String?, // µg/m3
                @SerializedName(value = "pollutant_cat")
                @Json(name = "pollutant_cat")
                val pollutantCat: String?, // Very Good
                @SerializedName(value = "pollutant_cat_idx")
                @Json(name = "pollutant_cat_idx")
                val pollutantCatIdx: Int?, // 1
                @SerializedName(value = "pollutant_idx")
                @Json(name = "pollutant_idx")
                val pollutantIdx: Int?, // 26
                @SerializedName(value = "primary_pollutant_ind")
                @Json(name = "primary_pollutant_ind")
                val primaryPollutantInd: String?, // Y
                @SerializedName(value = "pollutant_phrase")
                @Json(name = "pollutant_phrase")
                val pollutantPhrase: String? // Nitrogen Dioxide
        )
    }

    fun validate() {
        globalairquality.validateNoNullsInList()
    }
}
