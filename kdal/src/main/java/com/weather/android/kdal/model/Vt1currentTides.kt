package com.weather.android.kdal.model

//@JsonClass(generateAdapter = true)
data class Vt1currentTides(
        val type: List<String?>,
        val time: List<String?>,
        val height: List<Double?>
)
