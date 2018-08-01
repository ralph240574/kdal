package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1dailyforecast(
        val validDate: List<String>,
        val sunrise: List<String>,
        val sunset: List<String>,
        val moonIcon: List<String>,
        val moonPhrase: List<String>,
        val moonrise: List<String>,
        val moonset: List<String>,
        val dayOfWeek: List<String>,
        val snowQpf: List<Double>,
        val day: DayOrNight,
        val night: DayOrNight
) {
    data class DayOrNight(
            val dayPartName: List<String?>,
            val precipPct: List<Int?>,
            val precipAmt: List<Double?>,
            val precipType: List<String?>,
            val temperature: List<Int?>,
            val uvIndex: List<Int?>,
            val uvDescription: List<String?>,
            val icon: List<Int?>,
            val iconExtended: List<Int?>,
            val phrase: List<String?>,
            val narrative: List<String?>,
            val cloudPct: List<Int?>,
            val windDirCompass: List<String?>,
            val windDirDegrees: List<Int?>,
            val windSpeed: List<Int?>,
            val humidityPct: List<Int?>,
            val qualifier: List<String?>,
            val snowRange: List<String?>,
            val thunderEnum: List<Int?>,
            val thunderEnumPhrase: List<String?>
    )
}