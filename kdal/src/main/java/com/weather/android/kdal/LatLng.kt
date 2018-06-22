package com.weather.android.kdal

import java.text.NumberFormat
import java.util.*

class LatLng(val latitude: Double, val longitude: Double) {

    var fractionDigits: Int = 2

    init {
        checkRanges(latitude, longitude)
    }

    private fun getDecimalFormat(): NumberFormat {
        val nf = NumberFormat.getNumberInstance(Locale.US)
        nf.maximumFractionDigits = fractionDigits
        nf.minimumFractionDigits = fractionDigits
        nf.maximumIntegerDigits = 3
        return nf
    }

    fun toQueryParameter(): String {
        return getDecimalFormat().format(this.latitude) + "," + getDecimalFormat().format(this.longitude)
    }

    override fun toString(): String {
        return toQueryParameter()
    }

    companion object {

        private val MAX_LONGITUDE = 180.0

        private val MAX_LATITUDE = 90.0


        private fun checkRanges(latitude: Double, longitude: Double) {
            if (longitude > MAX_LONGITUDE || longitude < -MAX_LONGITUDE) {
                throw IllegalArgumentException("Longitude is out of range")
            }
            if (latitude > MAX_LATITUDE || latitude < -MAX_LATITUDE) {
                throw IllegalArgumentException("latitude is out of range ")
            }
        }

    }
}
