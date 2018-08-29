package com.weather.android.kdal

import org.junit.Assert.assertNotNull
import org.junit.Test


class ParsingTest {


    @Test
    fun testParseV3Obs() {


        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/V3-wx-observations-current.json")

        val obs = v3Agg?.v3WxObservationsCurrent

        println(obs)

    }


    @Test
    fun testParseV2fcstIntraday3() {

        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/v2fcstintraday3.json")

        println(v3Agg)

        val fcst = v3Agg?.v2fcstintraday3!!

        assertNotNull(v3Agg.v2fcstintraday3)
    }

    @Test
    fun testV2idxBreathingDaypart() {


        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/V2idxBreathingDaypart15.json")


        println(v3Agg?.v2idxBreathingDaypart15)
        v3Agg?.v2idxBreathingDaypart15?.validate()
        assertNotNull(v3Agg?.v2idxBreathingDaypart15)
    }

    @Test
    fun testV2idxDriveCurrent() {
        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/v2idxDriveCurrent.json")
        assertNotNull(v3Agg?.v2idxDriveCurrent)
    }


    @Test
    fun parsevV3wxconditionshistoricaldailysummary30day() {

        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/V3-wx-conditions-historical-dailysummary-30day.json")
        val start = System.currentTimeMillis()

        val hist = v3Agg?.v3WxConditionsHistoricalDailysummary30day!!
        assertNotNull(hist)
        println(hist)
        hist.validate()
    }

    @Test
    fun testV3GlobalAirQuality() {
        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/V3-wx-globalAirQuality.json")

        val v3WxGlobalAirQuality = v3Agg?.v3WxGlobalAirQuality

        assertNotNull(v3WxGlobalAirQuality)
        println(v3WxGlobalAirQuality)
    }

    @Test
    fun testParseV3Agg() {

        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/v3Agg2.json")

        val v3WxGlobalAirQuality = v3Agg?.v3WxGlobalAirQuality

        assertNotNull(v3WxGlobalAirQuality)
        println(v3Agg?.v3WxGlobalAirQuality)

        assertNotNull(v3Agg?.vt1wwir)
        println(v3Agg?.vt1wwir)

    }

    @Test
    fun testParsev3WxIndicesFluxDaily15day() {
        val v3Agg = V3RepoImpl.getV3AggFromFile("src/test/data/v3WxIndicesFluxDaily15day.json")


        val v3WxGlobalAirQuality = v3Agg?.v3WxIndicesFluxDaily15day

        assertNotNull(v3WxGlobalAirQuality)
        v3WxGlobalAirQuality?.validate()
        println(v3Agg?.v3WxIndicesFluxDaily15day)

    }


}