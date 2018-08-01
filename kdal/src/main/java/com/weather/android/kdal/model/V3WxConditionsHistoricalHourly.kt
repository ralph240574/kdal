package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxConditionsHistoricalHourly(
        val cloudCeiling: List<Integer?>,
        val dayOfWeek: List<String>,
        val dayOrNight: List<String>,
        val expirationTimeUtc: List<Long>,
        val iconCode: List<Integer?>,
        val precip24Hour: List<java.lang.Double?>,
        val pressureAltimeter: List<java.lang.Double?>,
        val pressureChange: List<java.lang.Double?>,
        val pressureMeanSeaLevel: List<java.lang.Double?>,
        val pressureTendencyCode: List<Integer?>,
        val pressureTendencyTrend: List<String?>,
        val relativeHumidity: List<Integer?>,
        val snow24Hour: List<java.lang.Double?>,
        val sunriseTimeLocal: List<String?>,
        val sunriseTimeUtc: List<java.lang.Long?>,
        val sunsetTimeLocal: List<String?>,
        val sunsetTimeUtc: List<java.lang.Long?>,
        val temperature: List<Integer?>,
        val temperatureChange24Hour: List<Integer?>,
        val temperatureDewPoint: List<Integer?>,
        val temperatureFeelsLike: List<Integer?>,
        val temperatureHeatIndex: List<Integer?>,
        val temperatureMax24Hour: List<Integer?>,
        val temperatureMaxSince7Am: List<Integer?>,
        val temperatureMin24Hour: List<Integer?>,
        val temperatureWindChill: List<Integer?>,
        val uvDescription: List<String?>,
        val uvIndex: List<Integer?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val visibility: List<java.lang.Double?>,
        val windDirection: List<Integer?>,
        val windDirectionCardinal: List<String?>,
        val windGust: List<Integer?>,
        val windSpeed: List<Integer?>,
        val wxPhraseLong: List<String?>
)
