package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxForecastDaily(
        val dayOfWeek: List<String>,
        val expirationTimeUtc: List<Long>,
        val moonPhase: List<String>,
        val moonPhaseCode: List<String>,
        val moonPhaseDay: List<Int>,
        val moonriseTimeLocal: List<String?>,
        val moonriseTimeUtc: List<String?>,
        val moonsetTimeLocal: List<String?>,
        val moonsetTimeUtc: List<java.lang.Long?>,
        val narrative: List<String>,
        val qpf: List<Double>,
        val qpfSnow: List<Double>,
        val sunriseTimeLocal: List<String?>,
        val sunriseTimeUtc: List<java.lang.Long?>,
        val sunsetTimeLocal: List<String?>,
        val sunsetTimeUtc: List<java.lang.Long?>,
        val temperatureMax: List<Int>,
        val temperatureMin: List<Int>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val daypart: List<Daypart>
) {
    data class Daypart(
            val cloudCover: List<Integer?>,
            val dayOrNight: List<String?>,
            val daypartName: List<String?>,
            val iconCode: List<Integer?>,
            val iconCodeExtend: List<Integer?>,
            val narrative: List<String?>,
            val precipChance: List<Integer?>,
            val precipType: List<String?>,
            val qpf: List<java.lang.Double?>,
            val qpfSnow: List<java.lang.Double?>,
            val qualifierPhrase: List<String?>,
            val relativeHumidity: List<Integer?>,
            val snowRange: List<String?>,
            val temperature: List<Integer?>,
            val temperatureHeatIndex: List<Integer?>,
            val temperatureWindChill: List<Integer?>,
            val thunderCategory: List<String?>,
            val thunderIndex: List<Integer?>,
            val uvDescription: List<String?>,
            val uvIndex: List<Integer?>,
            val windDirection: List<Integer?>,
            val windDirectionCardinal: List<String?>,
            val windPhrase: List<String?>,
            val windSpeed: List<Integer?>,
            val wxPhraseLong: List<String?>,
            val wxPhraseShort: List<String?>
    )
}
