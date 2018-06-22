package com.weather.android.kdal.model

data class V3alertsDetail(
        val alertDetail: AlertDetail
) {
    data class AlertDetail(
            val detailKey: String, // 1891f0ed-f39a-3566-8178-995c32998227
            val messageTypeCode: Int, // 1
            val messageType: String, // New
            val productIdentifier: String, // AQA
            val phenomena: String, // TAQ
            val significance: String, // L
            val eventTrackingNumber: String, // 0000
            val officeCode: String, // KEAX
            val officeName: String, // Kansas City/Pleasant Hill
            val officeAdminDistrict: String, // Missouri
            val officeAdminDistrictCode: String, // MO
            val officeCountryCode: String, // US
            val eventDescription: String, // Air Quality Alert
            val severityCode: Int, // 4
            val severity: String, // Minor
            val categories: List<Category>,
            val responseTypes: List<ResponseType>,
            val urgency: String, // Unknown
            val urgencyCode: Int, // 5
            val certainty: String, // Unknown
            val certaintyCode: Int, // 5
            val effectiveTimeLocal: Any?, // null
            val effectiveTimeLocalTimeZone: Any?, // null
            val expireTimeLocal: String, // 2018-07-09T21:00:00-05:00
            val expireTimeLocalTimeZone: String, // CDT
            val expireTimeUTC: Int, // 1531188000
            val onsetTimeLocal: Any?, // null
            val onsetTimeLocalTimeZone: Any?, // null
            val flood: Any?, // null
            val areaTypeCode: String, // Z
            val latitude: Double, // 39.11
            val longitude: Double, // -94.76
            val areaId: String, // KSZ104
            val areaName: String, // Wyandotte County
            val ianaTimeZone: String, // America/Chicago
            val adminDistrictCode: String, // KS
            val adminDistrict: String, // Kansas
            val countryCode: String, // US
            val countryName: String, // UNITED STATES OF AMERICA
            val headlineText: String, // Air Quality Alert until MON 9:00 PM CDT
            val source: String, // National Weather Service
            val disclaimer: Any?, // null
            val issueTimeLocal: String, // 2018-07-08T14:53:00-05:00
            val issueTimeLocalTimeZone: String, // CDT
            val identifier: String, // 17b79adadd31ceac001c92c127728cf0
            val processTimeUTC: Int, // 1531079609
            val texts: List<Text>,
            val polygon: Any?, // null
            val synopsis: Any? // null
    ) {
        data class Text(
                val languageCode: String, // en-US
                val description: String, // ...Air Quality Alert in effect for Monday July 09...The Mid-America Regional Council has issued an Air Quality Alert...ineffect for Monday July 9th. Outdoor Air Quality Index, or AQI, valuesin excess of 100 are expected with ozone being the primary pollutant.People and businesses are urged to avoid activities which lead toozone formation. These activities include refueling vehicles ortopping off when refueling idling vehicles unnecessarily and usinggasoline powered lawn equipment. Positive activities include carpooling, biking to work, delaying or combining errands, and usingwater-based paints and cleaners.When pollution levels are elevated, the Mid-America Regional Councilrecommends that individuals consider limiting strenuous outdoorphysical activity to reduce the risk of adverse health effects.People who may be especially sensitive to the effects of elevatedlevels of pollutants include the very young, and those with pre-existing respiratory problems such as asthma or heart disease. Thosewith symptoms should consider consulting their personal physician.For further information please see the Mid-America Regional Councilair quality program website at http://www.airqkc.org.
                val instruction: Any?, // null
                val overview: Any? // null
        )

        data class Category(
                val category: String, // Met
                val categoryCode: Int // 2
        )

        data class ResponseType(
                val responseType: String, // Avoid
                val responseTypeCode: Int // 5
        )
    }
}
