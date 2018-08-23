package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/1g_JApjNMMkUm029O_LSJG8XR_x3aVYQKuzOcfn3a_C0/edit">Lifestyle Indices - Driving Difficulty Index - v2</a>
 *
 */
@JsonClass(generateAdapter = true)
data class V2idxDriveCurrent(
        val metadata: Metadata,
        val drivingDifficultyIndexCurrent: DrivingDifficultyIndexCurrent
) {
    @JsonClass(generateAdapter = true)
    data class DrivingDifficultyIndexCurrent(
            val obsTime: Long, // 1529678934
            val obsTimeLocal: String, // 2018-06-22T09:48:54-0500
            val dow: String, // Friday
            val dayInd: String, // D
            val drivingDifficultyIndex: Int, // 0
            val drivingDifficultyCategory: String // None
    )

    @JsonClass(generateAdapter = true)
    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1529679464175:-1111038990
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Long, // 1529679584
            val statusCode: Int // 200
    )
}