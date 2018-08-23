package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">Lifestyle: Pollen Observations U.S.</a>
 *
 */
@JsonClass(generateAdapter = true)
data class Vt1pollenobs(
        val reportDate: String, // 2018-06-22T10:43:00Z
        val totalPollenCount: Int?, // null
        val tree: Int?, // 0
        val grass: Int?, // 0
        val weed: Int?, // 0
        val mold: Int? // 2
)
