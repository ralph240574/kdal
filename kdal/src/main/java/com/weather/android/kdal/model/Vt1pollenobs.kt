package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1pollenobs(
        val reportDate: String, // 2018-06-22T10:43:00Z
        val totalPollenCount: Int?, // null
        val tree: Int?, // 0
        val grass: Int?, // 0
        val weed: Int?, // 0
        val mold: Int? // 2
)
