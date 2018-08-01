package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1currentTides(
        val type: List<String?>,
        val time: List<String?>,
        val height: DoubleArray
)
