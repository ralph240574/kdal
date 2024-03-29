package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/1YsPfHxNcKWOE7K92mcY94AFRnEtHkD30r65SjnGkq9A/edit">Alerts Headline</a>
 *
 */
@JsonClass(generateAdapter = true)
data class Vt1alerts(
        val issueTime: List<String>,
        val effectiveTime: List<String?>,
        val endTime: List<String>,
        val areaType: List<String>,
        val areaId: List<String>,
        val areaName: List<String>,
        val headline: List<String>,
        val eventDescription: List<String>,
        val phenomenaCode: List<String>,
        val pil: List<String>,
        val severity: List<String>,
        val severityCode: List<Int>,
        val significanceCode: List<String>,
        val source: List<String>,
        val disclaimer: List<String?>,
        val officeName: List<String?>,
        val officeCode: List<String?>,
        val etn: List<String>,
        val texts: List<Text>
) {
    @JsonClass(generateAdapter = true)
    data class Text(
            val languageCode: List<String>,
            val description: List<String>,
            val instruction: List<String?>,
            val overview: List<String?>
    )
}

//TODO validate
