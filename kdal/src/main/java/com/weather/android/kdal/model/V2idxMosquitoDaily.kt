package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V2idxMosquitoDaily(
        val metadata: Metadata,
        val mosquitoIndex24hour: MosquitoIndex24hour,
        val mosquitoIndex12hour: MosquitoIndex12hour
) {
    data class MosquitoIndex24hour(
            val fcstValid: List<Int?>,
            val fcstValidLocal: List<String?>,
            val dow: List<String?>,
            val num: List<Int?>,
            val eveningMosquitoIndex: List<Int?>,
            val eveningMosquitoCategory: List<String?>
    )

    data class MosquitoIndex12hour(
            val fcstValid: List<Int?>,
            val fcstValidLocal: List<String?>,
            val dayInd: List<String?>,
            val num: List<Int?>,
            val daypartName: List<String?>,
            val mosquitoIndex: List<Int?>,
            val mosquitoCategory: List<String?>
    )

    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1532972642615:-362580358
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Int, // 1532973911
            val statusCode: Int // 200
    )
}
