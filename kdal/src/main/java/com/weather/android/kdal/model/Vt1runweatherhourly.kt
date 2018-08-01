package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1runweatherhourly(
        val fcstValid: List<java.lang.Long?>,
        val fcstValidLocal: List<String?>,
        val dow: List<String?>,
        val dayInd: List<String?>,
        val longRunWeatherIndex: List<Integer?>,
        val shortRunWeatherIndex: List<Integer?>,
        val temperature: List<Integer?>,
        val precipPct: List<Integer?>,
        val dewPoint: List<Integer?>,
        val cloudPct: List<Integer?>,
        val windSpeed: List<Integer?>
)