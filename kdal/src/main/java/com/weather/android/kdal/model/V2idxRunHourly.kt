package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

/**
 *
 * @see <a href="https://docs.google.com/document/d/13lCSBBUgOMXph08d1t54yKTDqV1q9SNBxNCg-FaupGc/edit">Lifestyle Indices - Running Weather Index - v2</a>
 *
 */
@JsonClass(generateAdapter = true)
data class V2idxRunHourly(
        val metadata: Metadata,
        val runWeatherIndex1hour: RunWeatherIndex1hour
) {
    @JsonClass(generateAdapter = true)
    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1534972992504:758010311
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val units: String, // e
            val expireTimeGmt: Int, // 1534973537
            val statusCode: Int // 200
    )

    @JsonClass(generateAdapter = true)
    data class RunWeatherIndex1hour(
            val fcstValid: List<Int>,
            val fcstValidLocal: List<String>,
            val num: List<Int>,
            val dow: List<String>,
            val dayInd: List<String>,
            val longRunWeatherIndex: List<Int>,
            val longRunWeatherCategory: List<String>,
            val shortRunWeatherIndex: List<Int>,
            val shortRunWeatherCategory: List<String>
    )

}