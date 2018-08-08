package com.weather.android.kdal.model

import com.weather.android.kdal.util.validateNoNullsInList

//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone, but nullability is not enforced
//@JsonClass(generateAdapter = true)
data class V3WxConditionsHistoricalHourly(
        val cloudCeiling: List<Int?>,
        val dayOfWeek: List<String>,
        val dayOrNight: List<String>,
        val expirationTimeUtc: List<Long>,
        val iconCode: List<Int?>,
        val precip24Hour: List<Double?>,
        val pressureAltimeter: List<Double?>,
        val pressureChange: List<Double?>,
        val pressureMeanSeaLevel: List<Double?>,
        val pressureTendencyCode: List<Int?>,
        val pressureTendencyTrend: List<String?>,
        val relativeHumidity: List<Int?>,
        val snow24Hour: List<Double?>,
        val sunriseTimeLocal: List<String?>,
        val sunriseTimeUtc: List<Long?>,
        val sunsetTimeLocal: List<String?>,
        val sunsetTimeUtc: List<Long?>,
        val temperature: List<Int?>,
        val temperatureChange24Hour: List<Int?>,
        val temperatureDewPoint: List<Int?>,
        val temperatureFeelsLike: List<Int?>,
        val temperatureHeatIndex: List<Int?>,
        val temperatureMax24Hour: List<Int?>,
        val temperatureMaxSince7Am: List<Int?>,
        val temperatureMin24Hour: List<Int?>,
        val temperatureWindChill: List<Int?>,
        val uvDescription: List<String?>,
        val uvIndex: List<Int?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val visibility: List<Double?>,
        val windDirection: List<Int?>,
        val windDirectionCardinal: List<String?>,
        val windGust: List<Int?>,
        val windSpeed: List<Int?>,
        val wxPhraseLong: List<String?>
) {
    fun validate() {
        checkNotNull(cloudCeiling)
        checkNotNull(dayOfWeek)
        checkNotNull(dayOrNight)
        checkNotNull(expirationTimeUtc)
        checkNotNull(iconCode)
        checkNotNull(precip24Hour)
        checkNotNull(pressureAltimeter)
        checkNotNull(pressureChange)
        checkNotNull(pressureMeanSeaLevel)
        checkNotNull(pressureTendencyCode)
        checkNotNull(pressureTendencyTrend)
        checkNotNull(relativeHumidity)
        checkNotNull(snow24Hour)
        checkNotNull(sunriseTimeLocal)
        checkNotNull(sunriseTimeUtc)
        checkNotNull(temperature)
        checkNotNull(temperatureChange24Hour)
        checkNotNull(temperatureDewPoint)
        checkNotNull(temperatureFeelsLike)
        checkNotNull(temperatureHeatIndex)
        checkNotNull(temperatureMax24Hour)
        checkNotNull(temperatureMaxSince7Am)
        checkNotNull(temperatureMin24Hour)
        checkNotNull(temperatureWindChill)
        checkNotNull(uvDescription)
        checkNotNull(uvIndex)
        checkNotNull(validTimeLocal)
        checkNotNull(validTimeUtc)
        checkNotNull(visibility)
        checkNotNull(windDirection)
        checkNotNull(windDirectionCardinal)
        checkNotNull(windGust)
        checkNotNull(windSpeed)
        checkNotNull(wxPhraseLong)


        dayOfWeek.validateNoNullsInList()
        dayOrNight.validateNoNullsInList()
        expirationTimeUtc.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()

    }
}
