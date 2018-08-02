package com.weather.android.kdal

import com.squareup.moshi.Moshi
import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.model.Vt1currentTides
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


        val v3DailyForecast = File("src/test/data/V3Daily.json").readText(Charsets.UTF_8)


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

//        tides?.height?.validateNoNullsInList()

        tides?.type?.forEach {
            println(it == null)
        }


    }

    @Test
    fun testParseV3Obs() {

        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)

        val v3wxObservationsCurrent = File("src/test/data/v3-wx-observations-current.json").readText(Charsets.UTF_8)

        val v3Agg = adapter.fromJson(v3wxObservationsCurrent)

        val obs = v3Agg?.v3WxObservationsCurrent

        println(obs)

    }


    @Test
    fun testParseV3fcstIntraday3() {

        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)

        val v2fcstintraday3 = File("src/test/data/v2fcstintraday3.json").readText(Charsets.UTF_8)

        val v3Agg = adapter.fromJson(v2fcstintraday3)

        val fcst = v3Agg?.v2fcstintraday3!!


        fcst.forecasts.forEach {
            println(it)
        }
    }


    @Test
    fun parsev3wxconditionshistoricaldailysummary30day() {

        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)

        val histJson = File("src/test/data/v3-wx-conditions-historical-dailysummary-30day.json").readText(Charsets.UTF_8)

        val v3Agg = adapter.fromJson(histJson)

        val hist = v3Agg?.v3WxConditionsHistoricalDailysummary30day!!

        println(hist)

hist.validate()
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