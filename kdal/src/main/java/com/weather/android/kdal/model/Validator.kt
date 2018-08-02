package com.weather.android.kdal.model


fun <T> List<T>.validateNoNullsInList(): List<T> {
    forEach {
        if (it == null) throw IllegalArgumentException("null element in list")
    }
    return this
}