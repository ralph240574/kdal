package com.weather.android.kdal.model

data class V3WxIndicesFluxDaily15day(
        val expirationTimeUtc: List<Int>,
        val fluxPrecipitationScore: List<Double>,
        val fluxPrecipitationType: List<Any>,
        val fluxTemperatureMaxScore: List<Double>,
        val fluxTemperatureMaxType: List<Any>,
        val fluxTemperatureMinScore: List<Double>,
        val fluxTemperatureMinType: List<Any>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Int>
)
