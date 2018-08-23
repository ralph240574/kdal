package com.weather.android.kdal.model

import com.squareup.moshi.JsonClass


/**
 *
 * @see <a href="https://docs.google.com/document/d/146TyvAUwVHdSooQXLrnKHymjTkMKB6elUAXUJmATbSA/edit">Snow and Ski Conditions - v3</a>
 *
 */
@JsonClass(generateAdapter = true)
data class V3WxSkiconditions(
        val adminDistrict: String?, // Chile
        val adminDistrictCode: String?, // CL-CL
        val attribution: String, // In Partnership with OnTheSnow.com
        val conditionsValidTimeLocal: String, // 2018-07-19T14:34:41-04:00
        val countryCode: String?, // CL
        val countryName: String?, // Chile
        val event: String?, // null
        val expireTimeLocal: String, // 2018-07-19T16:53:11-04:00
        val expireTimeUtc: Long, // 1532033591
        val hasNightSkiing: String, // Y
        val hasNordic: String, // Y
        val hasSkiing: String, // Y
        val hasTerrainPark: String, // Y
        val hasTubing: String, // Y
        val latitude: Double?, // -33.1667
        val liftsOpen: Int?, // 14
        val longitude: Double?, // -70.3333
        val nordicFacilities: Int?, // null
        val nordicOpenDistance: Int?, // null
        val nordicSkateGroomedDistance: Int?, // null
        val nordicTotalDistance: Int?, // null
        val nordicTracksetDistance: Int?, // null
        val nordicTrailsDistance: Int?, // null
        val percentLiftsOpen: Int, // 74
        val percentTerrainOpen: Int, // 50
        val projectedClosureDate: String?, // 2018-10-07
        val projectedOpenDate: String?, // 2018-06-09
        val resortAcres: Int?, // 2471
        val resortAcresOpen: Int?, // 0
        val resortEmail: String?, // ski@elcolorado.cl
        val resortLifts: Int?, // 19
        val resortName: String, // El Colorado
        val resortNameShort: String?, // El Colorado
        val resortOpenDistance: Int?, // null
        val resortOperatingStatus: String?, // Open
        val resortPhone: String?, // null
        val resortRuns: Int?, // 101
        val resortTrailSlopesOpen: Int?, // 50
        val resortWebsite: String?, // http://www.elcolorado.cl
        val ski: Int, // 754
        val snowDepthBase: Int, // 24
        val snowDepthTop: Int, // 28
        val snowFall24hours: Int, // 0
        val snowFall48hours: Int, // 0
        val snowFall72hours: Int, // 0
        val snowMaking: String, // Y
        val snowParkReshapeDate: String?, // null
        val snowPipesRecultureDate: String?, // null
        val surfacePrimary: String?, // Packed Powder
        val surfaceSecondary: String?, // null
        val terrainFeaturesCount: Int? // 0
)
