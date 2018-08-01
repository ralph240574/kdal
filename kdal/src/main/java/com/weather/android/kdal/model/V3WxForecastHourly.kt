package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxForecastHourly(
        val cloudCover: List<Int>,
        val dayOfWeek: List<String>,
        val dayOrNight: List<String>,
        val expirationTimeUtc: List<Long>,
        val iconCode: List<Int>,
        val iconCodeExtend: List<Int>,
        val precipChance: List<Int>,
        val precipType: List<String>,
        val pressureMeanSeaLevel: List<Double>,
        val qpf: List<Double>,
        val qpfSnow: List<Double>,
        val relativeHumidity: List<Int>,
        val temperature: List<Int>,
        val temperatureFeelsLike: List<Int>,
        val temperatureHeatIndex: List<Int>,
        val temperatureWindChill: List<Int>,
        val uvDescription: List<String>,
        val uvIndex: List<Int>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val visibility: List<Double>,
        val windDirection: List<Int>,
        val windDirectionCardinal: List<String>,
        val windGust: List<Integer?>,
        val windSpeed: List<Int>,
        val wxPhraseLong: List<String>,
        val wxPhraseShort: List<String?>,
        val wxSeverity: List<Int>
)
