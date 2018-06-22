package com.weather.sample.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.weather.android.kdal.LatLng
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

    @Inject
    lateinit var v3Repo: V3Repo


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


    private fun loadWeather() {

        Log.d(javaClass.toString(), " loading weather")

        val atlGeoCode = LatLng(33.92, -84.34)

        val nycGeoCode = "40.74,-74.00"

        val lonGeoCode = "51.50,0.00"


        v3Repo.latLng = atlGeoCode

        compositeDisposable?.add(observable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { v3Agg -> handleData(v3Agg) },
                        onError = { t -> handleError(t) })
        )
    }

    abstract fun observable(): Observable<V3Agg>;

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