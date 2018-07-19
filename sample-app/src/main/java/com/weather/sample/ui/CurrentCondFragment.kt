package com.weather.sample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg
import kotlinx.android.synthetic.main.current_conditions.*


class CurrentCondFragment : ContentFragment() {

    private val TAG: String = "CurrentCondFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.current_conditions, container, false)
    }

    override fun handleData(v3Agg: V3Agg) {
        Log.d(TAG, "handling data: ${v3Agg.v3WxObservationsCurrent}")
        item_obs_time.text = ("Obs. Time: ${v3Agg.v3WxObservationsCurrent?.validTimeLocal}")
        item_latlong.text = ("LatLong:  ${v3Agg.id}")
        item_current_temp.text = ("Current Temp: ${v3Agg.v3WxObservationsCurrent?.temperature} F");
        item_max.text = ("Max: ${v3Agg.v3WxObservationsCurrent?.temperatureMaxSince7Am} F");
        item_feels.text = ("feels: ${v3Agg.v3WxObservationsCurrent?.temperatureFeelsLike} F");
        item_phrase.text = (v3Agg.vt1wwir?.tersePhrase);
        item_wwir.text = (v3Agg.vt1wwir?.phrase);
    }


}
