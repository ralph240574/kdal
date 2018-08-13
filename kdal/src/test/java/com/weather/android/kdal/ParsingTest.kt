package com.weather.android.kdal

import com.squareup.moshi.Moshi
import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.model.Vt1currentTides
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File


class ParsingTest {


    val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)


    @Test
    fun testParseV3Obs() {

        val v3wxObservationsCurrent = File("src/test/data/v3-wx-observations-current.json").readText(Charsets.UTF_8)

        val start = System.currentTimeMillis()
        val v3Agg = adapter.fromJson(v3wxObservationsCurrent)

        val obs = v3Agg?.v3WxObservationsCurrent


        println("${System.currentTimeMillis() - start} ms")
        println(obs)

    }


    @Test
    fun testParseV2fcstIntraday3() {

        val v2fcstintraday3 = File("src/test/data/v2fcstintraday3.json").readText()

        val v3Agg = adapter.fromJson(v2fcstintraday3)

        println(v3Agg)

        val fcst = v3Agg?.v2fcstintraday3!!

        assertNotNull(v3Agg.v2fcstintraday3)
    }

    @Test
    fun testV2idxBreathingDaypart() {

        val v2idxBreathingDaypart15 = File("src/test/data/V2idxBreathingDaypart15.json").readText(Charsets.UTF_8)

        val start = System.currentTimeMillis()

        val v3Agg = adapter.fromJson(v2idxBreathingDaypart15)

        println("${System.currentTimeMillis() - start} ms")

        println(v3Agg?.v2idxBreathingDaypart15)
        v3Agg?.v2idxBreathingDaypart15?.validate()
        assertNotNull(v3Agg?.v2idxBreathingDaypart15)
    }

    @Test
    fun testV2idxDriveCurrent() {
        val v2idxDriveCurrent = File("src/test/data/v2idxDriveCurrent.json").readText(Charsets.UTF_8)
        val v3Agg = adapter.fromJson(v2idxDriveCurrent)
        println(v3Agg)
        assertNotNull(v3Agg?.v2idxDriveCurrent)
    }


    @Test
    fun parsev3wxconditionshistoricaldailysummary30day() {

        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)

        val histJson = File("src/test/data/v3-wx-conditions-historical-dailysummary-30day.json").readText(Charsets.UTF_8)
        val start = System.currentTimeMillis()
        val v3Agg = adapter.fromJson(histJson)
        println("${System.currentTimeMillis() - start} ms")

        val hist = v3Agg?.v3WxConditionsHistoricalDailysummary30day!!
        assertNotNull(hist)
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


    @Test
    fun testUtil() {

        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/v3Agg.json")


        println(v3Agg)
    }
}