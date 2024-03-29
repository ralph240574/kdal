package com.weather.android.kdal.model

import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1RY44O8ujbIA_tjlC4vYKHKzwSwEmNxuGw5sEJ9dYjG4/edit">Daily Forecast - (3, 5, 7, 10, 15 Day) - v3.0</a>
 *
 */

//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone
//@JsonClass(generateAdapter = true)
data class V3WxForecastDaily(
        val dayOfWeek: List<String>,
        val expirationTimeUtc: List<Long>,
        val moonPhase: List<String>,
        val moonPhaseCode: List<String>,
        val moonPhaseDay: List<Int>,
        val moonriseTimeLocal: List<String?>,
        val moonriseTimeUtc: List<String?>,
        val moonsetTimeLocal: List<String?>,
        val moonsetTimeUtc: List<Long?>,
        val narrative: List<String>,
        val qpf: List<Double>,
        val qpfSnow: List<Double>,
        val sunriseTimeLocal: List<String?>,
        val sunriseTimeUtc: List<Long?>,
        val sunsetTimeLocal: List<String?>,
        val sunsetTimeUtc: List<Long?>,
        val temperatureMax: List<Int?>,
        val temperatureMin: List<Int>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val daypart: List<Daypart>
) {
    // in the evening all the first elements will be null
    data class Daypart(
            val cloudCover: List<Int?>,
            val dayOrNight: List<String?>,
            val daypartName: List<String?>,
            val iconCode: List<Int?>,
            val iconCodeExtend: List<Int?>,
            val narrative: List<String?>,
            val precipChance: List<Int?>,
            val precipType: List<String?>,
            val qpf: List<Double?>,
            val qpfSnow: List<Double?>,
            val qualifierPhrase: List<String?>,
            val relativeHumidity: List<Int?>,
            val snowRange: List<String?>,
            val temperature: List<Int?>,
            val temperatureHeatIndex: List<Int?>,
            val temperatureWindChill: List<Int?>,
            val thunderCategory: List<String?>,
            val thunderIndex: List<Int?>,
            val uvDescription: List<String?>,
            val uvIndex: List<Int?>,
            val windDirection: List<Int?>,
            val windDirectionCardinal: List<String?>,
            val windPhrase: List<String?>,
            val windSpeed: List<Int?>,
            val wxPhraseLong: List<String?>,
            val wxPhraseShort: List<String?>
    )


    fun validate() {
        dayOfWeek.validateNoNullsInList()
        expirationTimeUtc.validateNoNullsInList()
        moonPhase.validateNoNullsInList()
        moonPhaseCode.validateNoNullsInList()
        moonPhaseDay.validateNoNullsInList()
        narrative.validateNoNullsInList()
        qpf.validateNoNullsInList()
        temperatureMin.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()
        daypart.validateNoNullsInList()
    }
}
