package com.weather.android.kdal

import com.weather.android.kdal.util.*
import org.junit.Assert.assertEquals
import org.junit.Test


class FormatUtilTest {

    @Test
    fun formatTemp() {

        val temp = 72;

        assertEquals("$temp $DEGREE_SYMBOL", temp.formatTemp(Units.METRIC))
        assertEquals("$temp $DEGREE_SYMBOL_C", temp.formatTemp(Units.METRIC, shortFormat = false))
        assertEquals("$temp $DEGREE_SYMBOL", temp.formatTemp(Units.HYBRID))
        assertEquals("$temp $DEGREE_SYMBOL_C", temp.formatTemp(Units.HYBRID, shortFormat = false))
        assertEquals("$temp $DEGREE_SYMBOL", temp.formatTemp(Units.ENGLISH))
        assertEquals("$temp $DEGREE_SYMBOL_F", temp.formatTemp(Units.ENGLISH, shortFormat = false))
        val temp2: Int? = null;
    }

    @Test
    fun formatWind() {

        val windDirectionCardinal = "SE"

        val wind = 10

        assertEquals("SE 10KPH", wind.formatWind(windDirectionCardinal, Units.METRIC))
        assertEquals("SE 10MPH", wind.formatWind(windDirectionCardinal, Units.HYBRID))
        assertEquals("SE 10MPH", wind.formatWind(windDirectionCardinal, Units.ENGLISH))
        assertEquals("calm", 0.formatWind(windDirectionCardinal, Units.METRIC))
        assertEquals("nada", 3.formatWind(windDirectionCardinal, Units.METRIC, calmString = "nada", minSpeedForCalm = 3))

    }


    @Test
    fun formatString() {

        val formatString = "%1\$sKMH"

        var speed: Number = 15
        assertEquals("15KMH", speed.format(formatString))
        speed = 20.5
        assertEquals("20.5KMH", speed.format(formatString))
        speed = -9.99999
        assertEquals("-9.99999KMH", speed.format(formatString))


    }

}