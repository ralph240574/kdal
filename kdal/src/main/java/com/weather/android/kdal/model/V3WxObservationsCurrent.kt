package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/1nQImKyn0tXze-wDYE3qSWV8aTnjyGC8bhG-pbUVQSeA/edit">Currents On Demand - v3.0</a>
 *
 */
@JsonClass(generateAdapter = true)
data class V3WxObservationsCurrent(
        val cloudCeiling: Int?, // null
        val cloudCoverPhrase: String, // Partly Cloudy
        val dayOfWeek: String, // Monday
        val dayOrNight: String, // D
        val expirationTimeUtc: Long, // 1531160597
        val iconCode: Int, // 30
        val obsQualifierCode: String?, // null
        val obsQualifierSeverity: Int?, // null
        val precip24Hour: Double?, // 0.09
        val pressureAltimeter: Double, // 30.15
        val pressureChange: Double, // -0.02
        val pressureMeanSeaLevel: Double, // 1021.9
        val pressureTendencyCode: Int, // 2
        val pressureTendencyTrend: String, // Falling
        val relativeHumidity: Int, // 81
        val snow24Hour: Double?, // 0.0
        val sunriseTimeLocal: String?, // 2018-07-09T06:33:18-0500
        val sunriseTimeUtc: Long?, // 1531135998
        val sunsetTimeLocal: String?, // 2018-07-09T20:27:48-0500
        val sunsetTimeUtc: Long?, // 1531186068
        val temperature: Int, // 79
        val temperatureChange24Hour: Int, // -1
        val temperatureDewPoint: Int, // 72
        val temperatureFeelsLike: Int, // 84
        val temperatureHeatIndex: Int, // 84
        val temperatureMax24Hour: Int, // 85
        val temperatureMaxSince7Am: Int, // 85
        val temperatureMin24Hour: Int, // 75
        val temperatureWindChill: Int, // 79
        val uvDescription: String, // Extreme
        val uvIndex: Int, // 11
        val validTimeLocal: String, // 2018-07-09T13:13:17-0500
        val validTimeUtc: Long, // 1531159997
        val visibility: Double, // 9.000
        val windDirection: Int, // 170
        val windDirectionCardinal: String, // S
        val windGust: Int?, // null
        val windSpeed: Int, // 3
        val wxPhraseLong: String, // Partly Cloudy
        val wxPhraseMedium: String, // Partly Cloudy
        val wxPhraseShort: String // P Cloudy
)
