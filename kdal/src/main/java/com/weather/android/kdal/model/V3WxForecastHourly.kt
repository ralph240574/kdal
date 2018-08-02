package com.weather.android.kdal.model

//@JsonClass(generateAdapter = true)
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
        val windGust: List<Int?>,
        val windSpeed: List<Int>,
        val wxPhraseLong: List<String>,
        val wxPhraseShort: List<String?>,
        val wxSeverity: List<Int>
) {
    fun validate() {
        cloudCover.validateNoNullsInList()
        dayOfWeek.validateNoNullsInList()
        dayOrNight.validateNoNullsInList()
        expirationTimeUtc.validateNoNullsInList()
        iconCode.validateNoNullsInList()
        iconCodeExtend.validateNoNullsInList()
        precipChance.validateNoNullsInList()
        precipType.validateNoNullsInList()
        pressureMeanSeaLevel.validateNoNullsInList()
        qpf.validateNoNullsInList()
        qpfSnow.validateNoNullsInList()
        relativeHumidity.validateNoNullsInList()
        temperature.validateNoNullsInList()
        temperatureFeelsLike.validateNoNullsInList()
        temperatureHeatIndex.validateNoNullsInList()
        temperatureWindChill.validateNoNullsInList()
        uvDescription.validateNoNullsInList()
        uvIndex.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()
        visibility.validateNoNullsInList()
        windDirection.validateNoNullsInList()
        windDirectionCardinal.validateNoNullsInList()
        windSpeed.validateNoNullsInList()
        wxPhraseLong.validateNoNullsInList()
        wxPhraseShort.validateNoNullsInList()
        wxSeverity.validateNoNullsInList()
    }
}
