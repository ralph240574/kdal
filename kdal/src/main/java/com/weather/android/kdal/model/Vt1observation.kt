package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1observation(
        val altimeter: Double, // 29.89
        val barometerTrend: String, // Falling
        val barometerCode: Int, // 2
        val barometerChange: Double, // -0.02
        val dewPoint: Int, // 72
        val feelsLike: Int, // 87
        val gust: Any?, // null
        val humidity: Int, // 74
        val icon: Int, // 30
        val observationTime: String, // 2018-06-21T14:39:20-0500
        val obsQualifierCode: String?, // null
        val obsQualifierSeverity: Int?, // null
        val phrase: String, // Partly Cloudy
        val precip24Hour: Double, // 0.67
        val snowDepth: Double, // 0.0
        val temperature: Int, // 81
        val temperatureMaxSince7am: Int, // 81
        val uvIndex: Int, // 10
        val uvDescription: String, // Very High
        val visibility: Double, // 10.000
        val windSpeed: Int, // 2
        val windDirCompass: String, // E
        val windDirDegrees: Int // 90
)
