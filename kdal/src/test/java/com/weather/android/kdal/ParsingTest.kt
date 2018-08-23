package com.weather.android.kdal

import com.squareup.moshi.Moshi
import com.weather.android.kdal.model.V3Agg
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File


class ParsingTest {


    val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)


    @Test
    fun testParseV3Obs() {

        val v3wxObservationsCurrent = File("src/test/data/V2idxRunHourly-wx-observations-current.json").readText(Charsets.UTF_8)

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

        val histJson = File("src/test/data/V2idxRunHourly-wx-conditions-historical-dailysummary-30day.json").readText(Charsets.UTF_8)
        val start = System.currentTimeMillis()
        val v3Agg = adapter.fromJson(histJson)
        println("${System.currentTimeMillis() - start} ms")

        val hist = v3Agg?.v3WxConditionsHistoricalDailysummary30day!!
        assertNotNull(hist)
        println(hist)
        hist.validate()
    }

    @Test
    fun testV3GlobalAirQuality() {
        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)
        val json = File("src/test/data/V2idxRunHourly-wx-globalAirQuality.json").readText()

        val v3Agg = adapter.fromJson(json)

        val v3WxGlobalAirQuality = v3Agg?.v3WxGlobalAirQuality

        assertNotNull(v3WxGlobalAirQuality)
        println(v3WxGlobalAirQuality)
    }

    @Test
    fun testParseV3Agg() {
        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)
        val v3AggJson = File("src/test/data/v3Agg2.json").readText()

        val v3Agg = adapter.fromJson(v3AggJson)

        val v3WxGlobalAirQuality = v3Agg?.v3WxGlobalAirQuality

        assertNotNull(v3WxGlobalAirQuality)
        println(v3Agg?.v3WxGlobalAirQuality)



        assertNotNull(v3Agg?.vt1wwir)
        println(v3Agg?.vt1wwir)

    }

    @Test
    fun testParsev3WxIndicesFluxDaily15day() {
        val adapter = Moshi.Builder().build().adapter<V3Agg>(V3Agg::class.java)
        val v3AggJson = File("src/test/data/v3WxIndicesFluxDaily15day.json").readText()

        val v3Agg = adapter.fromJson(v3AggJson)

        val v3WxGlobalAirQuality = v3Agg?.v3WxIndicesFluxDaily15day

        assertNotNull(v3WxGlobalAirQuality)
        v3WxGlobalAirQuality?.validate()
        println(v3Agg?.v3WxIndicesFluxDaily15day)

    }


}