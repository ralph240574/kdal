package com.weather.sample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weather.android.kdal.Product
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg
import io.reactivex.Observable


class CurrentCondFragment : ContentFragment() {

    private val TAG: String = "CurrentCondFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.current_conditions, container, false)
    }

    override fun handleData(v3Agg: V3Agg) {
        Log.d(TAG, "handling data")
        val view = view
        if (view != null) {
            (view.findViewById<View>(R.id.item_obs_time) as TextView).setText("Obs. Time: " + v3Agg.vt1observation?.observationTime)
            (view.findViewById<View>(R.id.item_latlong) as TextView).setText("LatLong: " + v3Agg.id)
            (view.findViewById(R.id.item_current_temp) as TextView).setText("Current Temp: " + v3Agg.vt1observation?.temperature + " F");
            (view.findViewById(R.id.item_max) as TextView).setText("Max: " + v3Agg.vt1observation?.temperatureMaxSince7am + " F");
            (view.findViewById(R.id.item_feels) as TextView).setText("feels: " + v3Agg.vt1observation?.feelsLike + " F");
            (view.findViewById(R.id.item_phrase) as TextView).setText(v3Agg.vt1wwir?.tersePhrase);
            (view.findViewById(R.id.item_wwir) as TextView).setText(v3Agg.vt1wwir?.phrase);
        }
    }


    override fun observable(): Observable<V3Agg> {
        return v3Repo.getV3Agg(setOf(
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
                Product.V3_WX_FORECAST_HOURLY_10_DAY)
        )
    }

}
