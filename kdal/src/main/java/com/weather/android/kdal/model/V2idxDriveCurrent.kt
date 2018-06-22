package com.weather.android.kdal.model


data class V2idxDriveCurrent(
        val metadata: Metadata,
        val drivingDifficultyIndexCurrent: DrivingDifficultyIndexCurrent
) {
    data class DrivingDifficultyIndexCurrent(
            val obsTime: Int, // 1529678934
            val obsTimeLocal: String, // 2018-06-22T09:48:54-0500
            val dow: String, // Friday
            val dayInd: String, // D
            val drivingDifficultyIndex: Int, // 0
            val drivingDifficultyCategory: String // None
    )

    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1529679464175:-1111038990
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Int, // 1529679584
            val statusCode: Int // 200
    )
}