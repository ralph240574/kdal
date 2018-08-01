package com.weather.android.kdal.model

data class v3(
        val id: String?, // 29.19,-96.27
        val vt1currentTides: Vt1currentTides?
) {
    data class Vt1currentTides(
            val type: List<String?>?,
            val time: List<String?>?,
            val height: List<Double?>?
    )
}