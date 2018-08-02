package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1idxBreathingDaypart(
        val day: DayOrNight,
        val night: DayOrNight
) {
    data class DayOrNight(
            val fcstValid: List<Long?>,
            val fcstValidLocal: List<String?>,
            val dayInd: List<String?>,
            val num: List<Int?>,
            val daypartName: List<String?>,
            val breathingIndex: List<Int?>,
            val breathingCategory: List<String?>
    )


}
