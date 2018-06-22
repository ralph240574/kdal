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


class DailyFragment : ContentFragment() {

    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_item_list_daily, container, false)

        if (view is RecyclerView) {
            val context = view.getContext()
            recyclerView = view
            recyclerView!!.layoutManager = LinearLayoutManager(context)
        }
        return view
    }


    override fun handleData(v3Agg: V3Agg) {
        recyclerView!!.adapter = DailyRecyclerViewAdapter(v3Agg.vt1dailyforecast!!)
        recyclerView!!.invalidate()
    }


    override fun observable(): Observable<V3Agg> {
        return v3Repo.getV3AggFromNetwork(setOf(
                Product.VT1_DAILYFORECAST,
                Product.VT1_OBSERVATION,
                Product.VT1_IDX_POLLEN_DAYPART,
                Product.VT1_RUNWEATHERHOURLY,
                Product.VT1_PRECIPITATION,
                Product.VT1_CURRENT_TIDES,
                Product.V2_IDX_DRIVE_CURRENT,
                Product.VT1_POLLENOBS,
                Product.VT1_LIGHTNING,
                Product.V2_GLOBALAIR,
                Product.VT1_WWIR,
                Product.VT1_ALERTS,
                Product.VT1_CONTENT_MODE,
                Product.VT1_IDX_BREATHING_DAYPART,
                Product.V2_FCSTINTRADAY3,
                Product.V3_ALERTS_HEADLINES,
                Product.V3_WX_CONDITIONS_HISTORICAL_DAILYSUMMARY_30_DAY,
                Product.V3_WX_CONDITIONS_HISTORICAL_HOURLY_1_DAY,
                Product.V3_WX_FORECAST_HOURLY_10_DAY)).toObservable()
    }
}
