package com.weather.android.kdal.model

import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1IeQP1PSRQMWVBqtxj2kMZvyym6GShU8u9I3FdwihMzw/edit">Hourly Forecast - (6hour, 12hour), (1, 2, 3, 10, 15 Day) - v3.0</a>
 *
 */
//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone
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
