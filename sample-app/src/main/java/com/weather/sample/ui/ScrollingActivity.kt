package com.weather.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.weather.android.kdal.Product
import com.weather.android.kdal.V3Repo
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg
import com.weather.sample.DemoApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*
import javax.inject.Inject

class ScrollingActivity : AppCompatActivity() {

    private val TAG = "V3AggData"

    lateinit var compositeDisposable: CompositeDisposable


    @Inject
    lateinit var v3Repo: V3Repo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        (application as DemoApplication).component.inject(this)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

    }

    override fun onStart() {
        super.onStart()

        loadData()
//        loadDataNetworkOnly()


    }

    private fun loadDataNetworkOnly() {
        val observable = v3Repo.getV3AggFromNetwork(setOf(Product.V3_WX_OBSERVATIONS_CURRENT))

        compositeDisposable.add(observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onSuccess = { v3Agg -> handleData(v3Agg) },
                        onError = { t -> handleError(t) }))
    }

    private fun loadData() {
        val observable = v3Repo.getV3Agg(setOf(Product.V3_WX_OBSERVATIONS_CURRENT, Product.V3_WX_SKICONDITIONS))

        compositeDisposable.add(observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { v3Agg -> handleData(v3Agg) },
                        onError = { t -> handleError(t) }))
    }


    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }

    private fun handleError(t: Throwable) {
        Log.e(TAG, "handle error " + t)

//        contentTV.text = t.toString()
    }

    private fun handleData(v3Agg: V3Agg) {
        Log.d(TAG, "handle data: " + v3Agg.v3WxSkiconditions)
        contentTV.text = v3Agg.v3WxObservationsCurrent?.temperature.toString()
    }
}
