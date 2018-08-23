package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/13lCSBBUgOMXph08d1t54yKTDqV1q9SNBxNCg-FaupGc/edit">Lifestyle Indices - Running Weather Index - v2</a>
 *
 */
@JsonClass(generateAdapter = true)
data class V2idxRunDaypart(
        val metadata: Metadata,
        val runWeatherIndex12hour: RunWeatherIndex12hour
) {
    @JsonClass(generateAdapter = true)
    data class RunWeatherIndex12hour(
            val fcstValid: List<Long>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val longRunWeatherIndex: List<Int>,
            val longRunWeatherCategory: List<String>,
            val shortRunWeatherIndex: List<Int>,
            val shortRunWeatherCategory: List<String>
    )

    @JsonClass(generateAdapter = true)
    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1531162452464:1764351240
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Long, // 1531163838
            val statusCode: Int // 200
    )

    fun validate() {
        runWeatherIndex12hour.fcstValid.validateNoNullsInList()
        runWeatherIndex12hour.fcstValidLocal.validateNoNullsInList()
        runWeatherIndex12hour.dayInd.validateNoNullsInList()
        runWeatherIndex12hour.num.validateNoNullsInList()
        runWeatherIndex12hour.daypartName.validateNoNullsInList()
        runWeatherIndex12hour.longRunWeatherIndex.validateNoNullsInList()
        runWeatherIndex12hour.shortRunWeatherCategory.validateNoNullsInList()
        runWeatherIndex12hour.shortRunWeatherIndex.validateNoNullsInList()
        runWeatherIndex12hour.shortRunWeatherCategory.validateNoNullsInList()
    }
}
