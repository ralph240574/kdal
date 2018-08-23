package com.weather.android.kdal.model

import com.weather.android.kdal.util.validateNoNullsInList


/**
 *
 * @see <a href="https://docs.google.com/document/d/1ipCwhzTiIDEkSvgxQGVeIcPzidEyxbFjy4LeolleJtI/edit">Pollen Historical - v3</a>
 *
 */
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
