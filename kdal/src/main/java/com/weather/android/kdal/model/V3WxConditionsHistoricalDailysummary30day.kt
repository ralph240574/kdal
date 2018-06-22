package com.weather.android.kdal.model


data class V3WxConditionsHistoricalDailysummary30day(
        val dayOfWeek: List<String>,
        val iconCodeDay: List<Int?>,
        val iconCodeNight: List<Int?>,
        val precip24Hour: List<Double?>,
        val rain24Hour: List<Double?>,
        val snow24Hour: List<Double?>,
        val temperatureMax: List<Int?>,
        val temperatureMin: List<Int?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Int>,
        val wxPhraseLongDay: List<String?>,
        val wxPhraseLongNight: List<String?>
)
