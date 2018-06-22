package com.weather.android.kdal.model


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
    data class Text(
            val languageCode: List<String>,
            val description: List<String>,
            val instruction: List<String?>,
            val overview: List<String?>
    )
}
