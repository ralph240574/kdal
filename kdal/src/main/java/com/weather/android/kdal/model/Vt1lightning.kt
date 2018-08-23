package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">DSX - Alerts: Lightning</a>
 *
 */
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
