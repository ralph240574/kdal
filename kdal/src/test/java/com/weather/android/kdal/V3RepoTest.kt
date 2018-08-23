package com.weather.android.kdal

import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.util.formatHHmm
import com.weather.android.kdal.util.getTimeOffset
import com.weather.android.kdal.util.toDate
import io.reactivex.rxkotlin.subscribeBy
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.File
import java.util.*
import kotlin.reflect.full.memberProperties


class V3RepoTest {

    val apiKey = "8de2d8b3a93542c9a2d8b3a935a2c909"


    var v3Repo = V3RepoImpl(apiKey = apiKey, baseUrl = "https://api.weather.com", cacheDir = File("./cache"), loggingEnabled = true)

    val products = setOf(


            Product.V3_LOCATION_POINT, //not needed right now, but may be very handy
            Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY,
            Product.V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY,
            Product.V3_ALERTS_HEADLINES,
            Product.V3_WX_OBSERVATIONS_CURRENT,
            Product.V3_WX_FORECAST_HOURLY_2_DAY,
            Product.V3_WX_FORECAST_DAILY_15_DAY,
            Product.V3_WX_GLOBAL_AIR_QUALITY,
            Product.VT1_WWIR,
            Product.VT1_CONTENT_MODE,
            Product.VT1_LIGHTNING,
            Product.VT1_PRECIPITATION,
            Product.VT1_CURRENT_TIDES,
            Product.V2_FCSTINTRADAY3,
            Product.V2_IDX_DRY_SKIN_DAYPART15,
            Product.V2_IDX_RUN_HOURLY24,
            Product.V2_IDX_MOSQUITO_DAILY_7

    )


    val atl = LatLng(33.89, -84.46)
    val nyc = LatLng(40.70, -74.00)
    val dehli = LatLng(28.6667, 77.2278)
    val jakarta = LatLng(-6.192794, 106.837253)
    val mumbai = LatLng(19.0886, 72.8832)
    val la = LatLng(34.0201597, -118.0)
    val berlin = LatLng(52.5065116, 13.14)
    val paris = LatLng(48.8588376, 2.276)
    val london = LatLng(51.5283063, -0.38)
    val tokyo = LatLng(35.6732615, 139.56)
    val moscow = LatLng(55.5807418, 36.8237461)
    val rome = LatLng(41.90, 12.49)
    val cairo = LatLng(30.0594698, 31.18)

    val latlongs = listOf(atl)

    val indianCities = File("src/test/data/IndianCities.tsv").readText().split("\n").map { it.toCity().toLatLong() }

    val USZipcodes = File("src/test/data/US_Zipcodes.csv").readText().split("\n").map { it.toZip().toLatLong() }


//    listOf(atl, nyc, dehli, jakarta, mumbai, la, berlin, paris, london, tokyo, moscow, rome, cairo)


    @Before
    fun setup() {
//        FileUtils.deleteDirectory(File("./cache"))
    }

    @Test
    fun parseDate() {


        val sunriseTimeLocal = "2018-07-25T06:43:56-0400"
        val sunriseTimeUtc = 1532515436L
        val sunsetTimeLocal = "2018-07-25T20:43:11-0400"
        val sunsetTimeUtc = 1532565791L


        println(sunriseTimeLocal.toDate())
        println(Date(sunriseTimeUtc * 1000L))
        println(sunriseTimeLocal.formatHHmm(true))

        println(sunsetTimeLocal.toDate())
        println(Date(sunsetTimeUtc * 1000L))
        println(sunsetTimeLocal.formatHHmm())
        println(sunsetTimeLocal.formatHHmm(true))

        println("".toDate())

        println("".formatHHmm())


        val s: String? = null


        println(s.getTimeOffset())
    }


    @Test
    fun testALot() {

        enumValues<Product>().filter { it != Product.VT1_CONTENT_MODE && it != Product.V3_ALERTS_DETAIL }.forEach { testProduct(it) }

    }


    @Test
    fun test() {
        testProduct(Product.V3_WX_OBSERVATIONS_CURRENT, mode = V3Repo.Mode.NETWORK_ONLY)
//        testProduct(Product.V2_IDX_RUN_DAY_PART15, mode = V3Repo.Mode.NETWORK_ONLY)
//        testProduct(Product.V2_IDX_RUN_HOURLY24, mode = V3Repo.Mode.NETWORK_ONLY)


//        testProduct(Product.VT1_CURRENT_TIDES)
//        testProduct(Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY)
//        testProduct(Product.V2_IDX_MOSQUITO_DAILY_7)

//        testProduct(Product.V2_IDX_MOSQUITO_DAILY_7, mode = V3Repo.Mode.OFFLINE)

//        testProduct(Product.V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY)


//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.EPA
        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)

//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.HJ6332012
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.ATMO
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.UBA
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.DAQI
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.NAQI
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.IMECA
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)
//        v3Repo.v3GlobalAirScaleParameterValue = V3WxGlobalAirQuality.SCALE_PARAMETER_VALUE.CAQI
//        testProduct(Product.V3_WX_GLOBAL_AIR_QUALITY)

//        val v3WxObsJson = """ {"id": "19.09,72.88",  "V2idxRunHourly-wx-observations-current":
//
//            {"cloudCeiling":9000,"cloudCoverPhrase":"Cloudy","dayOfWeek":"Tuesday","dayOrNight":"N","expirationTimeUtc":1533047411,"iconCode":27,"obsQualifierCode":null,"obsQualifierSeverity":null,"precip24Hour":0.16,"pressureAltimeter":29.68,"pressureChange":0.03,"pressureMeanSeaLevel":1005.1,"pressureTendencyCode":1,"pressureTendencyTrend":"Rising","relativeHumidity":83,"snow24Hour":0.0,"sunriseTimeLocal":"2018-07-31T06:14:43+0530","sunriseTimeUtc":1532997883,"sunsetTimeLocal":"2018-07-31T19:14:59+0530","sunsetTimeUtc":1533044699,"temperature":82,"temperatureChange24Hour":0,"temperatureDewPoint":77,"temperatureFeelsLike":91,"temperatureHeatIndex":91,"temperatureMax24Hour":86,"temperatureMaxSince7Am":86,"temperatureMin24Hour":82,"temperatureWindChill":82,"uvDescription":"Low","uvIndex":0,"validTimeLocal":"2018-07-31T19:50:11+0530","validTimeUtc":1533046811,"visibility":3.000,"windDirection":230,"windDirectionCardinal":"SW","windGust":24,"windSpeed":13,"wxPhraseLong":"Showers in the Vicinity","wxPhraseMedium":"Showers in Vicinity","wxPhraseShort":"Showers Near"}
//
//        }"""
//
//        val moshi = Moshi.Builder().build()
//
//        val adapter = moshi.adapter(V3Agg::class.java)
//
//
//        val v3Agg = adapter.fromJson(v3WxObsJson)
//
//
//        println(v3Agg)

    }


    fun testProduct(prod: Product, mode: V3Repo.Mode = V3Repo.Mode.NETWORK_ONLY, maxAge: Int = 60) {


        indianCities.forEach({ it ->
            v3Repo.latLng = it

            val observable =
                    v3Repo.getV3Agg(
                            setOf(prod),
                            latLng = v3Repo.latLng,
                            mode = mode, maxAgeResponseCache = maxAge)

            observable
//                .observeOn(AndroidSchedulers.mainThread())s
//                .subscribeOn(Schedulers.io())
                    .subscribe({ v3Agg -> checkV3Agg(prod, v3Agg) }, { throwable -> handleError(throwable) })

        })
    }


    @Test
    fun getV3Agg() {

        var counter = 0

        USZipcodes.filterIndexed({ index, value -> index % 100 == 0 }).forEach {
            val observable = v3Repo.getV3Agg(
                    products,
                    latLng = it,
                    mode = V3Repo.Mode.NETWORK_ONLY,
                    maxAgeResponseCache = 30)


            observable.subscribeBy(
                    onNext = {
                        println("${counter++}:  +++++++ ${it}")
                        assertNotNull(it)
                    },
                    onError = { println("XXXXXXXXXXXXXXX$it") }
            )
        }
    }




    @Test
    fun testfailure() {
        val observable = v3Repo.getV3Agg(
                products,
                latLng = atl,
                mode = V3Repo.Mode.NETWORK_ONLY,
                maxAgeResponseCache = 30)


        observable.subscribeBy(
                onNext = {
                    println("+++++++ ${it}")
                    assertNotNull(it)
                },
                onError = { println("XXXXXXXXXXXXXXX$it") }
        )


    }

    fun checkV3Agg(prod: Product, v3Agg: V3Agg?) {
        Assert.assertNotNull(v3Agg)

        val field = V3Agg::class.memberProperties.first {
            it.name.toLowerCase(Locale.US) == prod.toString().toLowerCase(Locale.US).replace("-", "")
        }

        if (v3Agg != null) {
            val v = field.get(v3Agg)
            assertNotNull(v)
            println(v)
        }
    }


    fun handleError(throwable: Throwable) {
        println(throwable)
        println(throwable.stackTrace)
        println("Thread: " + Thread.currentThread())
        Assert.assertTrue(false)

    }


    @Test
    fun cities() {
        val s = File("src/test/data/IndianCities.tsv").readText()

        val cities = s.split("\n").map { it.toCity().toLatLong() }

        cities.forEach { println(it) }

    }

    @Test
    fun zipCodes() {
        val s = File("src/test/data/US_Zipcodes.csv").readText()

        val zipCodes = s.split("\n").map { it.toZip().toLatLong() }

        zipCodes.forEach { println(it) }
    }


    data class City(val name: String, val lat: Double, val long: Double)

    data class Zip(val zip: String, val lat: Double, val long: Double)

    fun String.toZip(): Zip {
        val s = this.split(",")
        return Zip(s[0], s[1].toDouble(), s[2].toDouble())
    }

    fun Zip.toLatLong(): LatLng {
        return LatLng(this.lat, this.long)
    }

    fun String.toCity(): City {
        val s = this.split("\t")
        return City(s[0], s[1].toDouble(), s[2].toDouble())
    }

    fun City.toLatLong(): LatLng {
        return LatLng(this.lat, this.long)
    }

}