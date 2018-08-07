package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass
import com.weather.android.kdal.util.validateNoNullsInList

@JsonClass(generateAdapter = true)
data class V3WxIndicesFluxDaily(
        val expirationTimeUtc: List<Long>,
        val fluxPrecipitationScore: List<Double>,
        val fluxPrecipitationType: List<String?>,
        val fluxTemperatureMaxScore: List<Double>,
        val fluxTemperatureMaxType: List<String?>,
        val fluxTemperatureMinScore: List<Double>,
        val fluxTemperatureMinType: List<String?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>
) {
    fun validate() {
        expirationTimeUtc.validateNoNullsInList()
        fluxPrecipitationScore.validateNoNullsInList()
        fluxTemperatureMaxScore.validateNoNullsInList()
        fluxTemperatureMinScore.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()
    }
}
