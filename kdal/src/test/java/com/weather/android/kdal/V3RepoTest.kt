package com.weather.android.kdal

import com.weather.android.kdal.model.V3Agg
import com.weather.android.kdal.util.formatHHmm
import com.weather.android.kdal.util.getTimeOffset
import com.weather.android.kdal.util.toDate
import io.reactivex.rxkotlin.subscribeBy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File
import java.util.*
import kotlin.reflect.full.memberProperties


class V3RepoTest {

//    val apiKey = "1941878e0eef4b4c81878e0eeffb4cc2"

    val apiKey = "8de2d8b3a93542c9a2d8b3a935a2c909"


    var v3Repo = V3Repo(apiKey = apiKey, baseUrl = "http://api.weather.com", cacheDir = File("./cache"), loggingEnabled = true)

    val products = setOf(

            Product.VT1_ALERTS,
            Product.VT1_CONTENT_MODE,
            Product.VT1_CURRENT_TIDES,
            Product.VT1_DAILYFORECAST,
            Product.VT1_IDX_BREATHING_DAYPART,
            Product.VT1_IDX_POLLEN_DAYPART,
            Product.VT1_LIGHTNING,
            Product.VT1_NOWCAST,
            Product.VT1_OBSERVATION,
            Product.VT1_POLLENOBS,
            Product.VT1_PRECIPITATION,
            Product.VT1_RUNWEATHERHOURLY,
            Product.VT1_WWIR,
            Product.V2_FCSTINTRADAY3,
            Product.V2_GLOBALAIR,
            Product.V2_IDX_BREATHING_DAYPART15,
            Product.V2_IDX_DRIVE_CURRENT,
            Product.V2_IDX_POLLEN_DAYPART_15,
            Product.V2_IDX_RUN_DAY_PART15,
            Product.V3_ALERTS_HEADLINES,
            Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY,
            Product.V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY,
            Product.V3_WX_INDICES_FLUX_DAILY_15_DAY,
            Product.V3_WX_FORECAST_DAILY_15_DAY,
            Product.V3_WX_FORECAST_HOURLY_2_DAY,
            Product.V3_WX_FORECAST_HOURLY_10_DAY,
            Product.V3_WX_GLOBAL_AIR_QUALITY,
            Product.V3_WX_INDICES_FLUX_DAILY_15_DAY,
            Product.V3_WX_INDICES_POLLEN_HISTORICAL_1DAY,
            Product.V3_WX_OBSERVATIONS_CURRENT,
            Product.V2_IDX_MOSQUITO_DAILY_3

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
    val rome = LatLng(41.8504371, 11.95309)
    val cairo = LatLng(30.0594698, 31.18)

    val latlongs = listOf(atl, nyc, dehli, jakarta, mumbai, la, berlin, paris, london, tokyo, moscow, rome, cairo)


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
//        testProduct(Product.V3_WX_OBSERVATIONS_CURRENT)
//        testProduct(Product.VT1_CURRENT_TIDES)
//        testProduct(Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY)
        testProduct(Product.V3_WX_FORECAST_DAILY_15_DAY)


//        val v3WxObsJson = """ {"id": "19.09,72.88",  "v3-wx-observations-current":
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


    fun testProduct(prod: Product) {

        latlongs.forEach({ it ->
            v3Repo.latLng = it

            val observable =
                    v3Repo.getV3AggFromNetwork(
                            setOf(prod),
                            latLng = v3Repo.latLng)

            observable
//                .observeOn(AndroidSchedulers.mainThread())s
//                .subscribeOn(Schedulers.io())
                    .subscribe({ v3Agg -> checkV3Agg(prod, v3Agg) }, { throwable -> handleError(throwable) })

        })
    }


    @Test
    fun getV3Agg() {

        val observable = v3Repo.getV3Agg(
                products,
                latLng = v3Repo.latLng)


        observable.subscribeBy(
                onNext = {
                    println("+++++++ ${it}")
                },
                onError = { println(it) }
        )

    }

    @Test
    fun getV3AggFromCache() {


        latlongs.forEach({
            val single = v3Repo.getV3AggFromCache(
                    products,
                    latLng = it,
                    maxAgeResponse = 30)

            var t: Throwable? = null

            var result: V3Agg? = null

            val start = System.currentTimeMillis()

            single.subscribe(
                    { it ->
                        result = it
                        println("time: ${System.currentTimeMillis() - start}")
                    },
                    { throwable -> t = throwable })



            Assert.assertNull(t)
            Assert.assertNotNull(result)

            println(result)

            products.forEach {
                print("${it}: ")
                checkV3Agg(it, result!!)
            }
        })
    }


    @Test
    fun getV3AggFromNetworkAndCache() {

        val observable = v3Repo.getV3AggFromNetwork(products,
                latLng = v3Repo.latLng)

        var t: Throwable? = null

        var result: V3Agg? = null

        observable
                .subscribe({ v3Agg -> result = v3Agg },
                        { throwable ->
                            val observable2 = v3Repo.getV3AggFromCache(
                                    products,
                                    latLng = v3Repo.latLng,
                                    maxAgeResponse = 60)

                            observable2.subscribe({ v3Agg -> result = v3Agg },
                                    { throwable2 -> t = throwable2 })

                        })

//        Assert.assertNull(t)
        Assert.assertNotNull(result)

        products.forEach {
            print("${it}: ")
            checkV3Agg(it, result!!)
        }
    }

    @Test
    fun getV3AggFromNetwork() {

        val observable = v3Repo.getV3AggFromNetwork(products,
                latLng = v3Repo.latLng)

        var t: Throwable? = null

        var result: V3Agg? = null

        observable
                .subscribe({ v3Agg -> result = v3Agg },
                        { throwable ->
                            val observable2 = v3Repo.getV3AggFromCache(
                                    products,
                                    latLng = v3Repo.latLng,
                                    maxAgeResponse = 30)

                            observable2.subscribe({ v3Agg -> result = v3Agg },
                                    { throwable2 -> t = throwable2 })

                        })

//        Assert.assertNull(t)
        Assert.assertNotNull(result)
        println(result)


//        products.forEach {
//            print("${it}: ")
//            checkV3Agg(it, result!!)
//        }
    }


    fun checkV3Agg(prod: Product, v3Agg: V3Agg) {
        Assert.assertNotNull(v3Agg)

        val field = V3Agg::class.memberProperties.first {
            it.name.toLowerCase(Locale.US) == prod.toString().toLowerCase(Locale.US).replace("-", "")
        }

        println(field.get(v3Agg))
    }


    fun handleError(throwable: Throwable) {
        println(throwable)
        println(throwable.stackTrace)
        println("Thread: " + Thread.currentThread())
        Assert.assertTrue(false)

    }


}