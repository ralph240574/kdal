package com.weather.android.kdal

import com.weather.android.kdal.model.V3Agg
import io.reactivex.rxkotlin.subscribeBy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.full.memberProperties


class ExampleUnitTest {

    val apiKey = "1941878e0eef4b4c81878e0eeffb4cc2"

    var v3Repo = V3Repo(apiKey = apiKey, baseUrl = "http://api.weather.com")

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
            Product.V3_WX_OBSERVATIONS_CURRENT

    )


    //    Atl, NYC, Delhi, Jakarta, Mumbay
    val latlongs = listOf(
            LatLng(33.89, -84.46),
            LatLng(40.70, -74.00),
            LatLng(28.6667, 77.2278),
            LatLng(-6.192794, 106.837253),
            LatLng(19.0886, 72.8832))


    @Before
    fun setup() {
//        FileUtils.deleteDirectory(File("./cache"))
    }

    @Test
    fun parseDate() {

        val s = "2018-07-03T10:00:00-0400"

        val dateFormat = "yyyy-MM-dd'T'HH:mm:ssZZ"

        val date = LocalDateTime.parse(s, DateTimeFormatter.ofPattern(dateFormat, Locale.US))

        println(date)

        println(date.toLocalTime())

    }


    @Test
    fun testing() {

        enumValues<Product>().filter { it != Product.VT1_CONTENT_MODE && it != Product.V3_ALERTS_DETAIL }.forEach { testProduct(it) }


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

        val single = v3Repo.getV3AggFromCache(
                products,
                latLng = v3Repo.latLng,
                maxAgeResponse = 30)

        var t: Throwable? = null

        var result: V3Agg? = null

        single.subscribe({ it -> result = it }, { throwable -> t = throwable })


        Assert.assertNull(t)
        Assert.assertNotNull(result)

        products.forEach {
            print("${it}: ")
            checkV3Agg(it, result!!)
        }
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
//            checkV3Agg(it, result!!)
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

        products.forEach {
            print("${it}: ")
//            checkV3Agg(it, result!!)
        }
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