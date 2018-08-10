package com.weather.android.kdal.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3WxGlobalAirQuality(
        val globalairquality: Globalairquality
) {
    data class Globalairquality(
            val latitude: Double, // 29.19
            val longitude: Double, // -96.27
            val source: String, // Powered by Copernicus Atmosphere Monitoring Service
            val disclaimer: String, // Neither the European Commission nor ECMWF is responsible for any use of this information
            val airQualityIndex: Int, // 75
            val airQualityCategory: String, // Moderate
            val airQualityCategoryIndex: Int, // 2
            val airQualityCategoryIndexColor: String, // FFFF24
            val primaryPollutant: String, // PM2.5
            val pollutants: Pollutants,
            val messages: Messages,
            val expireTimeGmt: Long // 1531162800
    ) {
        data class Messages(
                @SerializedName(value = "Sensitive Group")
                @Json(name = "Sensitive Group")
                val sensitiveGroup: SensitiveGroup,
                @SerializedName(value = "General")
                @Json(name = "General")
                val general: General
        ) {
            data class SensitiveGroup(
                    val title: String, // Sensitive Group
                    val text: String // Consider reducing prolonged or heavy exertion. Watch for symptoms such as coughing or shortness of breath. These are signs to take it easier.
            )

            data class General(
                    val title: String, // General
                    val text: String // Air quality is acceptable; however, for some pollutants there may be a moderate health concern for a very small number of people who are unusually sensitive to air pollution.
            )
        }

        data class Pollutants(
                @SerializedName(value = "NO2")
                @Json(name = "NO2")
                val nO2: NO2,
                @SerializedName(value = "O3")
                @Json(name = "O3")
                val o3: O3,
                @SerializedName(value = "SO2")
                @Json(name = "SO2")
                val sO2: SO2,
                @SerializedName(value = "PM2.5")
                @Json(name = "PM2.5")
                val pM25: PM25,
                @SerializedName(value = "PM10")
                @Json(name = "PM10")
                val pM10: PM10,
                @SerializedName(value = "CO")
                @Json(name = "CO")
                val cO: CO
        ) {
            data class O3(
                    val name: String, // O3
                    val phrase: String, // Ozone
                    val amount: Double, // 56.20
                    val unit: String, // μg/m3
                    val category: String, // Good
                    val categoryIndex: Int, // 1
                    val index: Int // 22
            )

            data class PM25(
                    val name: String, // PM2.5
                    val phrase: String, // Particulate matter less than 2.5 microns
                    val amount: Double, // 38.25
                    val unit: String, // μg/m3
                    val category: String, // Moderate
                    val categoryIndex: Int, // 2
                    val index: Int // 75
            )

            data class CO(
                    val name: String, // CO
                    val phrase: String, // Carbon Monoxide
                    val amount: Double, // 92.38
                    val unit: String, // μg/m3
                    val category: String, // Good
                    val categoryIndex: Int, // 1
                    val index: Int // 1
            )

            data class PM10(
                    val name: String, // PM10
                    val phrase: String, // Particulate matter less than 10 microns
                    val amount: Double, // 49.16
                    val unit: String, // μg/m3
                    val category: String, // Good
                    val categoryIndex: Int, // 1
                    val index: Int // 28
            )

            data class NO2(
                    val name: String, // NO2
                    val phrase: String, // Nitrogen Dioxide
                    val amount: Double, // 1.48
                    val unit: String, // μg/m3
                    val category: String, // Good
                    val categoryIndex: Int, // 1
                    val index: Int // 1
            )

            data class SO2(
                    val name: String, // SO2
                    val phrase: String, // Sulfur Dioxide
                    val amount: Double, // 1.57
                    val unit: String, // μg/m3
                    val category: String, // Good
                    val categoryIndex: Int, // 1
                    val index: Int // 1
            )
        }
    }

    enum class SCALE_PARAMETER_VALUE {
        EPA,
        HJ6332012,
        ATMO,
        UBA,
        DAQI,
        NAQI,
        IMECA,
        CAQI
    }

}