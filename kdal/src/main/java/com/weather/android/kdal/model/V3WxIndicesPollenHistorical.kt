package com.weather.android.kdal.model
//adapter generation does not seem to work for List with nullables elements,
//but moshi can handle this alone
//@JsonClass(generateAdapter = true)
data class V3WxIndicesPollenHistorical(
        val reportTimeLocal: List<String>,
        val treePollenIndex: List<Int?>,
        val treePollenDescription: List<String?>,
        val grassPollenIndex: List<Int?>,
        val grassPollenDescription: List<String?>,
        val ragweedPollenIndex: List<Int?>,
        val ragweedPollenDescription: List<String?>
) {
    fun validate() {
        reportTimeLocal.validateNoNullsInList()
    }
}
