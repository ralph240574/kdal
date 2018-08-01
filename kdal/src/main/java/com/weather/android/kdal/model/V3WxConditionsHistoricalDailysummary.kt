package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class V3WxConditionsHistoricalDailysummary(
        val dayOfWeek: List<String>,
        val iconCodeDay: List<java.lang.Integer?>,
        val iconCodeNight: List<Integer?>,
        val precip24Hour: List<java.lang.Double?>,
        val rain24Hour: List<java.lang.Double?>,
        val snow24Hour: List<java.lang.Double?>,
        val temperatureMax: List<Integer?>,
        val temperatureMin: List<Integer?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val wxPhraseLongDay: List<String?>,
        val wxPhraseLongNight: List<String?>
)
