package com.weather.android.kdal.model

//@JsonClass(generateAdapter = true)
data class V3WxConditionsHistoricalDailysummary(
        val dayOfWeek: List<String>,
        val iconCodeDay: List<Int?>,
        val iconCodeNight: List<Int?>,
        val precip24Hour: List<Double?>,
        val rain24Hour: List<Double?>,
        val snow24Hour: List<Double?>,
        val temperatureMax: List<Int?>,
        val temperatureMin: List<Int?>,
        val validTimeLocal: List<String>,
        val validTimeUtc: List<Long>,
        val wxPhraseLongDay: List<String?>,
        val wxPhraseLongNight: List<String?>
) {

    fun validate() {
        dayOfWeek.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()
    }
}