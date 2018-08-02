package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1idxPollenDaypart(
        val day: Day,
        val night: Night
) {
    data class Day(
            val fcstValid: List<Long?>,
            val fcstValidLocal: List<String?>,
            val dayInd: List<String?>,
            val num: List<Int?>,
            val daypartName: List<String?>,
            val grassPollenIndex: List<Int?>,
            val grassPollenCategory: List<String?>,
            val treePollenIndex: List<Int?>,
            val treePollenCategory: List<String?>,
            val ragweedPollenIndex: List<Int?>,
            val ragweedPollenCategory: List<String?>
    )

    data class Night(
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
        night.fcstValid.validateNoNullsInList()
        night.fcstValidLocal.validateNoNullsInList()
        night.dayInd.validateNoNullsInList()
        night.num.validateNoNullsInList()
        night.daypartName.validateNoNullsInList()
        night.grassPollenIndex.validateNoNullsInList()
        night.grassPollenCategory.validateNoNullsInList()
        night.treePollenIndex.validateNoNullsInList()
        night.treePollenCategory.validateNoNullsInList()
        night.ragweedPollenIndex.validateNoNullsInList()
        night.ragweedPollenCategory.validateNoNullsInList()
    }

}
