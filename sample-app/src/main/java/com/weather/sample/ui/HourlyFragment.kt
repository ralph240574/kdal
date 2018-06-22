package com.weather.sample.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.android.kdal.Product
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg
import io.reactivex.Observable


class HourlyFragment : ContentFragment() {


    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_item_list_hourly, container, false)

        if (view is RecyclerView) {
            val context = view.getContext()
            recyclerView = view
            recyclerView!!.layoutManager = LinearLayoutManager(context)
        }
        return view
    }


    override fun handleData(v3Agg: V3Agg) {
        recyclerView!!.adapter = HourlyRecyclerViewAdapter(v3Agg.v3WxForecastHourly10day!!)
        recyclerView!!.invalidate()
    }


    override fun observable(): Observable<V3Agg> {
        return v3Repo.getV3AggFromNetwork(setOf(
                Product.V3_WX_FORECAST_HOURLY_10_DAY)).toObservable()
    }
}
