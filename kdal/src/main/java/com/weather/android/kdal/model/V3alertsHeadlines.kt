package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3alertsHeadlines(
        val metadata: Metadata,
        val alerts: List<Alert>
) {
    data class Metadata(
            val next: Int? // null
    )

    data class Alert(
            val detailKey: String, // 7b09e553-2eb0-3dd6-bc87-b60f5a5f6af2
            val messageTypeCode: Int, // 2
            val messageType: String, // Update
            val productIdentifier: String, // IWW
            val phenomena: String, // TWA
            val significance: String, // S
            val eventTrackingNumber: String, // DE026:TWA:S:2018:06:22
            val officeCode: String, // EUDE
            val officeName: String?, // Deutscher Wetterdienst
            val officeAdminDistrict: String?, // null
            val officeAdminDistrictCode: String?,
            val officeCountryCode: String?, // GM
            val eventDescription: String, // Potential disruption due to wind
            val severityCode: Int, // 4
            val severity: String, // Minor
            val categories: List<Category>,
            val responseTypes: List<ResponseType>,
            val urgency: String, // Unknown
            val urgencyCode: Int, // 5
            val certainty: String, // Unknown
            val certaintyCode: Int, // 5
            val effectiveTimeLocal: String?, // 2018-06-22T08:11:00+02:00
            val effectiveTimeLocalTimeZone: String?, // CEST
            val expireTimeLocal: String, // 2018-06-22T20:00:00+02:00
            val expireTimeLocalTimeZone: String, // CEST
            val expireTimeUTC: Long, // 1529690400
            val onsetTimeLocal: String?, // 2018-06-22T08:11:00+02:00
            val onsetTimeLocalTimeZone: String?, // CEST
            val flood: Flood?, // null
            val areaTypeCode: String, // Z
            val latitude: Double?, // 51.39
            val longitude: Double?, // 9.41
            val areaId: String, // DE026
            val areaName: String, // Kreis und Stadt Kassel
            val ianaTimeZone: String?, // Europe/Berlin
            val adminDistrictCode: String?,
            val adminDistrict: String?, // null
            val countryCode: String, // DE
            val countryName: String, // GERMANY
            val headlineText: String, // Potential disruption due to wind from FRI 8:11 AM CEST until FRI 8:00 PM CEST
            val source: String, // EUMETNET - MeteoAlarm
            val disclaimer: String?, // Time delays between this website and <a href='http://meteoalarm.eu/'>Meteoalarm.eu</a> are possible. For the most up-to-date information about alert levels as published by the participating National Meteorological Services, please visit <a href='http://meteoalarm.eu/'>Meteoalarm</a>.
            val issueTimeLocal: String, // 2018-06-22T18:02:51+02:00
            val issueTimeLocalTimeZone: String, // CEST
            val identifier: String, // 2437604aba3151beba43f44343bb2668
            val processTimeUTC: Long // 1529683875
    ) {
        data class Category(
                val category: String, // Met
                val categoryCode: Int // 2
        )

        data class ResponseType(
                val responseType: String, // Avoid
                val responseTypeCode: Int // 5
        )
        data class Flood(
                val floodLocationId: String?, // 00000
                val floodLocationName: String?, // N/A
                val floodSeverityCode: String?, // 0
                val floodSeverity: String?, // N/A
                val floodImmediateCauseCode: String?, // ER
                val floodImmediateCause: String?, // Excessive Rainfall
                val floodRecordStatusCode: String?, // OO
                val floodRecordStatus: String?, // N/A
                val floodStartTimeLocal: String?, // null
                val floodStartTimeLocalTimeZone: String?, // null
                val floodCrestTimeLocal: String?, // null
                val floodCrestTimeLocalTimeZone: String?, // null
                val floodEndTimeLocal: String?, // null
                val floodEndTimeLocalTimeZone: String? // null
        )
    }
}