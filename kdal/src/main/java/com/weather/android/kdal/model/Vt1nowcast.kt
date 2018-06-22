package com.weather.android.kdal.model


data class Vt1nowcast(
        val icon: Int, // 38
        val narrative128Char: String, // Sctd t-storms after 4:15pm. Winds NE at 5 to 10 mph. Chance of rain 60%.
        val narrative256Char: String, // Scattered showers and thunderstorms developing by 4:15pm. Partly cloudy. Temperatures slowly falling to near 83F. Winds NE at 5 to 10 mph. Chance of rain 60%.
        val narrative32Char: String, // Sctd t-storms after 4:15pm.
        val narrative512Char: String, // Scattered showers and thunderstorms developing by 4:15pm. Partly cloudy. Temperatures slowly falling to near 83F. Winds NE at 5 to 10 mph. Chance of rain 60%.
        val peakSeverity: Int, // 2
        val peakWind: Int, // 8
        val processTime: String, // 2018-07-06T13:00:00-0500
        val precipAmt: Double // 0.09
)
