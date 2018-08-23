package com.weather.android.kdal.model

import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1Pu-Es3GiION9xP_R8AuhSnl6EeyB_6vXE0JjgQ2cyCA/edit">Historical Conditions - Daily Summary - v3.0</a>
 *
 */
//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone
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

        dayOfWeek!!
        iconCodeDay!!
        iconCodeNight!!
        precip24Hour!!
        rain24Hour!!
        snow24Hour!!
        temperatureMax!!
        temperatureMin!!
        validTimeLocal!!
        validTimeUtc!!
        wxPhraseLongDay!!
        wxPhraseLongNight!!

        dayOfWeek.validateNoNullsInList()
        validTimeLocal.validateNoNullsInList()
        validTimeUtc.validateNoNullsInList()
    }
}