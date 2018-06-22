package com.weather.android.kdal.model

data class Vt1contentMode(
        val mode: String, // normal
        val effectiveDateTime: String, // 2017-09-08T00:00:00+00:00
        val eventName: String,
        val eventClickUrl: EventClickUrl
) {
    data class EventClickUrl(
            val android: String,
            val ios: String
    )
}
