// Code generated by moshi-kotlin-codegen. Do not edit.
package com.weather.android.kdal.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class Vt1runweatherhourlyJsonAdapter(moshi: Moshi) : JsonAdapter<Vt1runweatherhourly>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("fcstValid", "fcstValidLocal", "dow", "dayInd", "longRunWeatherIndex", "shortRunWeatherIndex", "temperature", "precipPct", "dewPoint", "cloudPct", "windSpeed")

    private val listOfNullableLongAdapter: JsonAdapter<List<Long?>> =
            moshi.adapter<List<Long?>>(Types.newParameterizedType(List::class.java, Long::class.java)).nonNull()

    private val listOfNullableStringAdapter: JsonAdapter<List<String?>> =
            moshi.adapter<List<String?>>(Types.newParameterizedType(List::class.java, String::class.java)).nonNull()

    private val listOfNullableIntAdapter: JsonAdapter<List<Int?>> =
            moshi.adapter<List<Int?>>(Types.newParameterizedType(List::class.java, Int::class.java)).nonNull()

    override fun toString(): String = "GeneratedJsonAdapter(Vt1runweatherhourly)"

    override fun fromJson(reader: JsonReader): Vt1runweatherhourly {
        var fcstValid: List<Long?>? = null
        var fcstValidLocal: List<String?>? = null
        var dow: List<String?>? = null
        var dayInd: List<String?>? = null
        var longRunWeatherIndex: List<Int?>? = null
        var shortRunWeatherIndex: List<Int?>? = null
        var temperature: List<Int?>? = null
        var precipPct: List<Int?>? = null
        var dewPoint: List<Int?>? = null
        var cloudPct: List<Int?>? = null
        var windSpeed: List<Int?>? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> fcstValid = listOfNullableLongAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'fcstValid' was null at ${reader.path}")
                1 -> fcstValidLocal = listOfNullableStringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'fcstValidLocal' was null at ${reader.path}")
                2 -> dow = listOfNullableStringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'dow' was null at ${reader.path}")
                3 -> dayInd = listOfNullableStringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'dayInd' was null at ${reader.path}")
                4 -> longRunWeatherIndex = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'longRunWeatherIndex' was null at ${reader.path}")
                5 -> shortRunWeatherIndex = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'shortRunWeatherIndex' was null at ${reader.path}")
                6 -> temperature = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'temperature' was null at ${reader.path}")
                7 -> precipPct = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'precipPct' was null at ${reader.path}")
                8 -> dewPoint = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'dewPoint' was null at ${reader.path}")
                9 -> cloudPct = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'cloudPct' was null at ${reader.path}")
                10 -> windSpeed = listOfNullableIntAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'windSpeed' was null at ${reader.path}")
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Vt1runweatherhourly(
                fcstValid = fcstValid ?: throw JsonDataException("Required property 'fcstValid' missing at ${reader.path}"),
                fcstValidLocal = fcstValidLocal ?: throw JsonDataException("Required property 'fcstValidLocal' missing at ${reader.path}"),
                dow = dow ?: throw JsonDataException("Required property 'dow' missing at ${reader.path}"),
                dayInd = dayInd ?: throw JsonDataException("Required property 'dayInd' missing at ${reader.path}"),
                longRunWeatherIndex = longRunWeatherIndex ?: throw JsonDataException("Required property 'longRunWeatherIndex' missing at ${reader.path}"),
                shortRunWeatherIndex = shortRunWeatherIndex ?: throw JsonDataException("Required property 'shortRunWeatherIndex' missing at ${reader.path}"),
                temperature = temperature ?: throw JsonDataException("Required property 'temperature' missing at ${reader.path}"),
                precipPct = precipPct ?: throw JsonDataException("Required property 'precipPct' missing at ${reader.path}"),
                dewPoint = dewPoint ?: throw JsonDataException("Required property 'dewPoint' missing at ${reader.path}"),
                cloudPct = cloudPct ?: throw JsonDataException("Required property 'cloudPct' missing at ${reader.path}"),
                windSpeed = windSpeed ?: throw JsonDataException("Required property 'windSpeed' missing at ${reader.path}"))
        return result
    }

    override fun toJson(writer: JsonWriter, value: Vt1runweatherhourly?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("fcstValid")
        listOfNullableLongAdapter.toJson(writer, value.fcstValid)
        writer.name("fcstValidLocal")
        listOfNullableStringAdapter.toJson(writer, value.fcstValidLocal)
        writer.name("dow")
        listOfNullableStringAdapter.toJson(writer, value.dow)
        writer.name("dayInd")
        listOfNullableStringAdapter.toJson(writer, value.dayInd)
        writer.name("longRunWeatherIndex")
        listOfNullableIntAdapter.toJson(writer, value.longRunWeatherIndex)
        writer.name("shortRunWeatherIndex")
        listOfNullableIntAdapter.toJson(writer, value.shortRunWeatherIndex)
        writer.name("temperature")
        listOfNullableIntAdapter.toJson(writer, value.temperature)
        writer.name("precipPct")
        listOfNullableIntAdapter.toJson(writer, value.precipPct)
        writer.name("dewPoint")
        listOfNullableIntAdapter.toJson(writer, value.dewPoint)
        writer.name("cloudPct")
        listOfNullableIntAdapter.toJson(writer, value.cloudPct)
        writer.name("windSpeed")
        listOfNullableIntAdapter.toJson(writer, value.windSpeed)
        writer.endObject()
    }
}