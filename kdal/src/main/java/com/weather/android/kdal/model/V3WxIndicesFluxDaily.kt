package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxIndicesFluxDaily15day(
        val expirationTimeUtc: List<Long>,
        val fluxPrecipitationScore: List<Double>,
        val fluxPrecipitationType: List<String?>,
        val fluxTemperatureMaxScore: List<Double>,
        val fluxTemperatureMaxType: List<String?>,
        val fluxTemperatureMinScore: List<Double>,
        val fluxTemperatureMinType: List<String?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>
)
