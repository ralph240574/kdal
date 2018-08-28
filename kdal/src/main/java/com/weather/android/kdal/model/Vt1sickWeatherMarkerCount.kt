package com.weather.android.kdal.model

import com.squareup.moshi.Json

data class Vt1sickWeatherMarkerCount(
        @Json(name = "1")
        val x1: Int, // 725
        @Json(name = "18")
        val x18: Int, // 440
        @Json(name = "4")
        val x4: Int // 78
)
