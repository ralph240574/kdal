package com.weather.sample.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.weather.android.kdal.LatLng
import com.weather.android.kdal.Product
import com.weather.android.kdal.V3Repo
import com.weather.android.kdal.model.V3Agg
import com.weather.sample.DemoApplication
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


abstract class ContentFragment : Fragment() {

    private var compositeDisposable: CompositeDisposable? = null

    val maxAgeResposeInSec = 60

    @Inject
    lateinit var v3Repo: V3Repo

    val products = setOf(
            Product.VT1_IDX_POLLEN_DAYPART,
            Product.VT1_RUNWEATHERHOURLY,
            Product.VT1_PRECIPITATION,
            Product.VT1_CURRENT_TIDES,
            Product.V2_IDX_DRIVE_CURRENT,
            Product.VT1_POLLENOBS,
            Product.VT1_LIGHTNING,
            Product.V2_IDX_DRY_SKIN_DAYPART15,
            Product.VT1_WWIR,
            Product.VT1_ALERTS,
            Product.VT1_CONTENT_MODE,
            Product.VT1_IDX_BREATHING_DAYPART,
            Product.V2_FCSTINTRADAY3,
            Product.V3_WX_OBSERVATIONS_CURRENT,
            Product.V3_ALERTS_HEADLINES,
            Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY,
            Product.V3_WX_FORECAST_DAILY_15_DAY,
            Product.V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY,
            Product.V3_WX_FORECAST_HOURLY_10_DAY)


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(javaClass.toString(), "onCreate Fragment")
        super.onCreate(savedInstanceState)
        ((context as Activity).application as DemoApplication).component.inject(this)
        compositeDisposable = CompositeDisposable()
    }


    override fun onStart() {
        super.onStart()

        loadWeather()
    }


    override fun onDestroy() {
        Log.d(javaClass.toString(), "onDestroy Fragment")

        super.onDestroy()
        compositeDisposable?.dispose()
    }


    fun loadWeather() {

        Log.d(javaClass.toString(), " loading weather ${v3Repo.mode}")

//        val atlGeoCode = LatLng(33.92, -84.34)

        val nycGeoCode = LatLng(40.74, -74.00)

        val lonGeoCode = "51.50,0.00"


        v3Repo.latLng = nycGeoCode

        compositeDisposable?.add(observable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { handleData(it) },
                        onError = { handleError(it) })
        )
    }

    fun observable(): Observable<V3Agg> {
        return v3Repo.getV3Agg(products, maxAgeResponseCache = maxAgeResposeInSec)
    }

    abstract fun handleData(v3Agg: V3Agg)

    companion object {

        fun newInstance(pos: Int): Fragment {
            val fragment: Fragment
            if (pos == 0) {
                fragment = CurrentCondFragment()
            } else if (pos == 1) {
                fragment = HourlyFragment()
            } else if (pos == 2) {
                fragment = DailyFragment()
            } else {
                throw IllegalArgumentException("pos must be <=2")
            }
            return fragment
        }
    }

    fun handleError(throwable: Throwable) {
//        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
        Log.e(javaClass.toString(), throwable.toString(), throwable);
    }


}