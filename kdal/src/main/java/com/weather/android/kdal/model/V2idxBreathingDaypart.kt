package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList

@JsonClass(generateAdapter = true)
data class V2idxBreathingDaypart(
        val metadata: Metadata,
        val breathingIndex12hour: BreathingIndex12hour
) {
    @JsonClass(generateAdapter = true)
    data class BreathingIndex12hour(
            val fcstValid: List<Long>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val breathingIndex: List<Int>,
            val breathingCategory: List<String>
    )

    @JsonClass(generateAdapter = true)
    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1531162260091:72086062
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Long, // 1531163838
            val statusCode: Int // 200
    )


    fun validate() {
        breathingIndex12hour.fcstValid.validateNoNullsInList()
        breathingIndex12hour.fcstValidLocal.validateNoNullsInList()
        breathingIndex12hour.dayInd.validateNoNullsInList()
        breathingIndex12hour.num.validateNoNullsInList()
        breathingIndex12hour.daypartName.validateNoNullsInList()
        breathingIndex12hour.breathingIndex.validateNoNullsInList()
        breathingIndex12hour.breathingCategory.validateNoNullsInList()
    }
}
