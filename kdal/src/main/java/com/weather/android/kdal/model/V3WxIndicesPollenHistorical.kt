package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxIndicesPollenHistorical(
        val reportTimeLocal: List<String>,
        val treePollenIndex: List<Integer?>,
        val treePollenDescription: List<String?>,
        val grassPollenIndex: List<Integer?>,
        val grassPollenDescription: List<String?>,
        val ragweedPollenIndex: List<Integer?>,
        val ragweedPollenDescription: List<String?>
)
