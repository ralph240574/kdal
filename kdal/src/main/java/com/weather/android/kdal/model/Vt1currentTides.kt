package com.weather.android.kdal.model
//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone
//@JsonClass(generateAdapter = true)
data class Vt1currentTides(
        val type: List<String?>,
        val time: List<String?>,
        val height: List<Double?>
)
