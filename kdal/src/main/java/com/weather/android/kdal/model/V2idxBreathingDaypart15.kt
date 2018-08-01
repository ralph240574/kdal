package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V2idxBreathingDaypart15(
        val metadata: Metadata,
        val breathingIndex12hour: BreathingIndex12hour
) {
    data class BreathingIndex12hour(
            val fcstValid: List<Long>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val breathingIndex: List<Int>,
            val breathingCategory: List<String>
    )

    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1531162260091:72086062
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Long, // 1531163838
            val statusCode: Int // 200
    )
}
