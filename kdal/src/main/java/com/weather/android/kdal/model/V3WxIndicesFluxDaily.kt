package com.weather.android.kdal.model

data class V3WxIndicesFluxDaily15day(
        val expirationTimeUtc: List<Int>,
        val fluxPrecipitationScore: List<Double>,
        val fluxPrecipitationType: List<String?>,
        val fluxTemperatureMaxScore: List<Double>,
        val fluxTemperatureMaxType: List<String?>,
        val fluxTemperatureMinScore: List<Double>,
        val fluxTemperatureMinType: List<String?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Int>
)
