package com.weather.android.kdal.util


fun <T> List<T>.validateNoNullsInList(): List<T> {
    forEach {
        if (it == null) throw IllegalArgumentException("null element in list")
    }
    return this
}