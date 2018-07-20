package com.weather.android.kdal.model

data class V3WxIndicesPollenHistorical(
        val reportTimeLocal: List<String>,
        val treePollenIndex: List<Int?>,
        val treePollenDescription: List<String?>,
        val grassPollenIndex: List<Int?>,
        val grassPollenDescription: List<String?>,
        val ragweedPollenIndex: List<Int?>,
        val ragweedPollenDescription: List<String?>
)
