package com.weather.android.kdal.model

//@JsonClass(generateAdapter = true)
data class Vt1runweatherhourly(
        val fcstValid: List<Long?>,
        val fcstValidLocal: List<String?>,
        val dow: List<String?>,
        val dayInd: List<String?>,
        val longRunWeatherIndex: List<Int?>,
        val shortRunWeatherIndex: List<Int?>,
        val temperature: List<Int?>,
        val precipPct: List<Int?>,
        val dewPoint: List<Int?>,
        val cloudPct: List<Int?>,
        val windSpeed: List<Int?>
)