package com.weather.android.kdal.model

data class Vt1idxPollenDaypart(
        val day: DayOrNight,
        val night: DayOrNight
) {
    data class DayOrNight(
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

}
