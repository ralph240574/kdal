package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">DSX - Utility: Content Mode/a>
 *
 */
@JsonClass(generateAdapter = true)
data class Vt1contentMode(
        val mode: String, // normal
        val effectiveDateTime: String, // 2017-09-08T00:00:00+00:00
        val eventName: String,
        val eventClickUrl: EventClickUrl?
) {
    @JsonClass(generateAdapter = true)
    data class EventClickUrl(
            val android: String,
            val ios: String
    )
}
