package com.weather.sample.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg


class DailyFragment : ContentFragment() {

    private val TAG = "DailyFragment"

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
        Log.d(TAG, "handling data: ${v3Agg.vt1dailyforecast}")
        recyclerView!!.adapter = DailyRecyclerViewAdapter(v3Agg.vt1dailyforecast!!)
        recyclerView!!.invalidate()
    }

}
