package com.weather.android.kdal.model

data class V2idxRunDaypart15(
        val metadata: Metadata,
        val runWeatherIndex12hour: RunWeatherIndex12hour
) {
    data class RunWeatherIndex12hour(
            val fcstValid: List<Int>,
            val fcstValidLocal: List<String>,
            val dayInd: List<String>,
            val num: List<Int>,
            val daypartName: List<String>,
            val longRunWeatherIndex: List<Int>,
            val longRunWeatherCategory: List<String>,
            val shortRunWeatherIndex: List<Int>,
            val shortRunWeatherCategory: List<String>
    )

    data class Metadata(
            val language: String, // en-US
            val transactionId: String, // 1531162452464:1764351240
            val version: String, // 1
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val expireTimeGmt: Int, // 1531163838
            val statusCode: Int // 200
    )
}
