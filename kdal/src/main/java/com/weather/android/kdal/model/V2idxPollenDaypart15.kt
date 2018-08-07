package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList

@JsonClass(generateAdapter = true)
data class V2idxPollenDaypart15(
        val metadata: Metadata,
        val pollenForecast12hour: PollenForecast12hour
) {
    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1531160039954:146197209
            val version: String, // 1
            val latitude: Double, // 25.78
            val longitude: Double, // -80.29
            val expireTimeGmt: Long, // 1531160279
            val statusCode: Int // 200
    )

    data class PollenForecast12hour(
            val fcstValid: List<Long>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val grassPollenIndex: List<Int>,
            val grassPollenCategory: List<String>,
            val treePollenIndex: List<Int>,
            val treePollenCategory: List<String>,
            val ragweedPollenIndex: List<Int>,
            val ragweedPollenCategory: List<String>
    )

    fun validate() {
        pollenForecast12hour.fcstValid.validateNoNullsInList()
        pollenForecast12hour.fcstValidLocal.validateNoNullsInList()
        pollenForecast12hour.dayInd.validateNoNullsInList()
        pollenForecast12hour.num.validateNoNullsInList()
        pollenForecast12hour.daypartName.validateNoNullsInList()
        pollenForecast12hour.grassPollenIndex.validateNoNullsInList()
        pollenForecast12hour.grassPollenCategory.validateNoNullsInList()
        pollenForecast12hour.treePollenIndex.validateNoNullsInList()
        pollenForecast12hour.treePollenCategory.validateNoNullsInList()
        pollenForecast12hour.ragweedPollenIndex.validateNoNullsInList()
        pollenForecast12hour.ragweedPollenCategory.validateNoNullsInList()
    }
}
