// Code generated by moshi-kotlin-codegen. Do not edit.
package com.weather.android.kdal.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import kotlin.Double
import kotlin.String
import kotlin.collections.List

class Vt1currentTidesJsonAdapter(moshi: Moshi) : JsonAdapter<Vt1currentTides>() {
    private val options: JsonReader.Options = JsonReader.Options.of("type", "time", "height")

    private val listOfNullableStringAdapter: JsonAdapter<List<String?>> =
            moshi.adapter<List<String?>>(Types.newParameterizedType(List::class.java, String::class.java)).nonNull()

    private val listOfNullableDoubleAdapter: JsonAdapter<List<Double?>> =
            moshi.adapter<List<Double?>>(Types.newParameterizedType(List::class.java, Double::class.java)).nonNull()

    override fun toString(): String = "GeneratedJsonAdapter(Vt1currentTides)"

    override fun fromJson(reader: JsonReader): Vt1currentTides {
        var type: List<String?>? = null
        var time: List<String?>? = null
        var height: List<Double?>? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> type = listOfNullableStringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'type' was null at ${reader.path}")
                1 -> time = listOfNullableStringAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'time' was null at ${reader.path}")
                2 -> height = listOfNullableDoubleAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'height' was null at ${reader.path}")
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Vt1currentTides(
                type = type ?: throw JsonDataException("Required property 'type' missing at ${reader.path}"),
                time = time ?: throw JsonDataException("Required property 'time' missing at ${reader.path}"),
                height = height ?: throw JsonDataException("Required property 'height' missing at ${reader.path}"))
        return result
    }

    override fun toJson(writer: JsonWriter, value: Vt1currentTides?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("type")
        listOfNullableStringAdapter.toJson(writer, value.type)
        writer.name("time")
        listOfNullableStringAdapter.toJson(writer, value.time)
        writer.name("height")
        listOfNullableDoubleAdapter.toJson(writer, value.height)
        writer.endObject()
    }
}
