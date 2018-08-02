package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1idxBreathingDaypart(
        val day: Day,
        val night: Night
) {
    data class Day(
            val fcstValid: List<Long?>,
            val fcstValidLocal: List<String?>,
            val dayInd: List<String?>,
            val num: List<Int?>,
            val daypartName: List<String?>,
            val breathingIndex: List<Int?>,
            val breathingCategory: List<String?>
    )

    data class Night(
            val fcstValid: List<Long>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val breathingIndex: List<Int>,
            val breathingCategory: List<String>
    )

}
