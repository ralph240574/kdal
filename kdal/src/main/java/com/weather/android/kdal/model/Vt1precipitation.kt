package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">Short-Range Forecast: Precipitation Forecast</a>
 *
 */
@JsonClass(generateAdapter = true)
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
) {
    fun validate() {
        characteristic.validateNoNullsInList()
        startTime.validateNoNullsInList()
        endTime.validateNoNullsInList()
        eventType.validateNoNullsInList()
        forecastedRainAmount.validateNoNullsInList()
        forecastedSnowAmount.validateNoNullsInList()
        intensity.validateNoNullsInList()
        severity.validateNoNullsInList()
        imminence.validateNoNullsInList()
    }
}