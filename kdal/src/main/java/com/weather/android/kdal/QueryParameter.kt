package com.weather.android.kdal

enum class QueryParameter(val parameter: String) {
    UNITS("units"),
    LANGUAGE("language"),
    DATE_YYYYMMdd("date"),
    SCALE("scale"),
    ALERT_ID("alertId");

    override fun toString(): String = parameter
}