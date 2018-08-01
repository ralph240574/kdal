package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class V3LocationPoint(
        val location: Location
) {
    data class Location(
            val latitude: Double, // 29.22
            val longitude: Double, // -96.29
            val city: String?, // El Campo
            val locale: Locale?,
            val neighborhood: String?, // null
            val adminDistrict: String?, // Texas
            val adminDistrictCode: String?, // TX
            val postalCode: String?, // 77437
            val postalKey: String?, // 77437:US
            val country: String?, // United States
            val countryCode: String?, // US
            val ianaTimeZone: String?, // America/Chicago
            val displayName: String?, // El Campo
            val dstEnd: String?, // 2018-11-04T01:00:00-0600
            val dstStart: String?, // 2018-03-11T03:00:00-0500
            val dmaCd: String?, // null
            val placeId: String?, // 7f87e69f4c96fc8c76c4227742ba56ab28fce39f98a54e53293a47715427c3c7
            val countyId: String?, // null
            val zoneId: String? // null
    ) {
        data class Locale(
                val locale1: String?, // null
                val locale2: String?, // El Campo
                val locale3: String?, // null
                val locale4: String? // null
        )
    }
}
