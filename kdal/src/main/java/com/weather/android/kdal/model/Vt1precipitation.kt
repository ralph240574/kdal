package com.weather.android.kdal.model

data class Vt1precipitation(
        val characteristic: List<Int>,
        val startTime: List<String>,
        val endTime: List<String>,
        val eventType: List<Int>,
        val forecastedRainAmount: List<Double>,
        val forecastedSnowAmount: List<Double>,
        val intensity: List<Int>,
        val severity: List<Int>,
        val imminence: List<Int>
)