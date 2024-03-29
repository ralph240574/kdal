package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">Short-Range Forecast: (WWIR) When Will It Rain Forecast</a>
 *
 */
@JsonClass(generateAdapter = true)
data class Vt1wwir(
        val processTime: String, // 2018-06-22T11:00:00-0500
        val overallType: Int, // 0
        val phrase: String, // Expect dry conditions over the next six hours.
        val tersePhrase: String, // Dry conditions will continue.
        val phraseTemplate: String, // Expect dry conditions over the next six hours.
        val tersePhraseTemplate: String, // Dry conditions will continue.
        val precipDay: String?, // null
        val precipTime24hr: String?, // null
        val precipTime12hr: String?, // null
        val precipTimeIso: String?, // null
        val timeZoneAbbreviation: String // CDT
)
