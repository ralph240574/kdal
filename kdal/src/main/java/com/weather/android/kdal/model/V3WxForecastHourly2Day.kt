package com.weather.android.kdal.model


data class V3WxForecastHourly2day(
        val cloudCover: List<Int>,
        val dayOfWeek: List<String>,
        val dayOrNight: List<String>,
        val expirationTimeUtc: List<Int>,
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
        val validTimeUtc: List<Int>,
        val visibility: List<Double>,
        val windDirection: List<Int>,
        val windDirectionCardinal: List<String>,
        val windGust: List<Any>,
        val windSpeed: List<Int>,
        val wxPhraseLong: List<String>,
        val wxPhraseShort: List<String>,
        val wxSeverity: List<Int>
)
