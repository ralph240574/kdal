package com.weather.android.kdal

import com.squareup.moshi.Moshi
import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.model.Vt1currentTides
import com.weather.android.kdal.model.validateNoNullsInList
import org.junit.Test
import java.io.File


class ParsingTest {

    @Test
    fun testParsing() {

        val vt1currentTidesJson = """ {
                         "id": "29.19,-96.27",
            "vt1currentTides":
                             {"type":[null,"H","L","H","L","H","L"],
                              "time":["2018-08-01T02:31:00-0500","2018-08-01T10:17:00-0500","2018-08-01T14:20:00-0500","2018-08-01T18:43:00-0500","2018-08-02T02:52:00-0500","2018-08-02T10:11:00-0500","2018-08-02T15:39:00-0500"],
                              "height":[null,0.3,0.3,0.3,0.2,0.3,null]}
        }"""


        val obs = """{"id": "29.19,-96.27",  "v3-wx-observations-current":

   {"cloudCeiling":null,"cloudCoverPhrase":"crap","dayOfWeek":"Wednesday","dayOrNight":"D","expirationTimeUtc":1533150998,"iconCode":34,"obsQualifierCode":null,"obsQualifierSeverity":null,"precip24Hour":0.24,"pressureAltimeter":29.96,"pressureChange":-0.04,"pressureMeanSeaLevel":1014.8,"pressureTendencyCode":2,"pressureTendencyTrend":"Falling","relativeHumidity":31,"snow24Hour":0.0,"sunriseTimeLocal":"2018-08-01T06:45:51-0500","sunriseTimeUtc":1533123951,"sunsetTimeLocal":"2018-08-01T20:17:02-0500","sunsetTimeUtc":1533172622,"temperature":93,"temperatureChange24Hour":0,"temperatureDewPoint":58,"temperatureFeelsLike":94,"temperatureHeatIndex":94,"temperatureMax24Hour":94,"temperatureMaxSince7Am":93,"temperatureMin24Hour":72,"temperatureWindChill":93,"uvDescription":"Extreme","uvIndex":11,"validTimeLocal":"2018-08-01T14:06:38-0500","validTimeUtc":1533150398,"visibility":9.000,"windDirection":350,"windDirectionCardinal":"N","windGust":null,"windSpeed":7,"wxPhraseLong":"Fair","wxPhraseMedium":"Fair","wxPhraseShort":"Fair"}

      }"""


        val v3DailyForecast = File("src/test/V3Daily.json").readText(Charsets.UTF_8)


//        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val moshi = Moshi.Builder().build()

        val adapter = moshi.adapter<V3Agg>(V3Agg::class.java)


        val v3Agg = adapter.fromJson(v3DailyForecast)


        val daily = v3Agg?.v3WxForecastDaily15day

        daily?.validate()

        println(daily?.moonPhaseDay)

//        println(v3Agg?.v3WxObservationsCurrent)
//
//        println(v3Agg?.v3WxObservationsCurrent?.cloudCoverPhrase == null)

        val tides = v3Agg?.vt1currentTides

        tides?.height?.forEach {
            println(it)
        }

        tides?.height?.validateNoNullsInList()

        tides?.type?.forEach {
            println(it == null)
        }


    }


    @Test
    fun testingStuff() {

        val type = listOf("a", "b")

        val time = listOf("1", "2")

        val height = listOf(.5, .0)

        val tides = Vt1currentTides(type, time, height);


//        tides.height.forEach { println(it) }

//        println(tides.height.javaClass.name)


    }
}