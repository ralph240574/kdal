package com.weather.android.kdal.util

import com.weather.android.kdal.Units


const val DEGREE_SYMBOL = "°"
const val DEGREE_SYMBOL_F = "$DEGREE_SYMBOL F"
const val DEGREE_SYMBOL_C = "$DEGREE_SYMBOL C"

fun Int.formatTemp(units: Units, shortFormat: Boolean = true): String {
    if (shortFormat) {
        return "$this $DEGREE_SYMBOL";
    } else {
        return when (units) {
            Units.ENGLISH -> "$this $DEGREE_SYMBOL_F"
            Units.HYBRID, Units.METRIC -> "$this $DEGREE_SYMBOL_C"
        }
    }
}

fun Int.formatWind(
        windDirectionCardinal: String,
        units: Units,
        calmString: String = "calm",
        minSpeedForCalm: Int = 0,
        mphString: String = "MPH",
        kmhString: String = "KPH")
        : String {

    if (minSpeedForCalm >= this) {
        return calmString
    } else {
        return "$windDirectionCardinal $this${getWindspeedUnit(units, mphString, kmhString)}"
    }
}

fun getWindspeedUnit(units: Units, mphString: String, kmhString: String): String {

    return when (units) {
        Units.ENGLISH, Units.HYBRID -> mphString
        Units.METRIC -> kmhString
    }
}


fun Number.format(formatString: String): String {
    return String.format(formatString, this)
}



