package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class V2idxDrySkinDaypart15(
        val metadata: Metadata?,
        val drySkinIndex12hour: DrySkinIndex12hour?
) {
    data class DrySkinIndex12hour(
            val fcstValid: List<Int?>?,
            val fcstValidLocal: List<String?>?,
            val dayInd: List<String?>?,
            val num: List<Int?>?,
            val daypartName: List<String?>?,
            val drySkinIndex: List<Int?>?,
            val drySkinCategory: List<String?>?
    )

    data class Metadata(
            val language: String?, // en-US
            val transactionId: String?, // 1533740363052:1594264002
            val version: String?, // 1
            val latitude: Double?, // 29.19
            val longitude: Double?, // -96.27
            val expireTimeGmt: Int?, // 1533741087
            val statusCode: Int? // 200
    )
}
