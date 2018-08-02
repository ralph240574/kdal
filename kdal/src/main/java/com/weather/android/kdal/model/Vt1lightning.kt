package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vt1lightning(
        val strikeTime: List<String>,
        val latitude: List<Double>,
        val longitude: List<Double>,
        val distance: List<Double>
) {
    fun validate() {
        strikeTime.validateNoNullsInList()
        latitude.validateNoNullsInList()
        longitude.validateNoNullsInList()
        distance.validateNoNullsInList()
    }
}
