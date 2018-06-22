package com.weather.sample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3Agg
import kotlinx.android.synthetic.main.row_weather.view.*


class WeatherAdapter(private val v3Agg: V3Agg) : RecyclerView.Adapter<WeatherAdapter.WeatherDataHolder>() {


    override fun onBindViewHolder(holder: WeatherDataHolder, position: Int) {

        val dailysummary30day = v3Agg.v3WxConditionsHistoricalDailysummary30day


        holder.itemView.item_title.text = dailysummary30day?.dayOfWeek?.get(position)


        val dayPhrase = dailysummary30day?.wxPhraseLongDay?.get(position)
        val nightPhrase = dailysummary30day?.wxPhraseLongNight?.get(position)
        val maxTemp = dailysummary30day?.temperatureMax?.get(position)
        val minTemp = dailysummary30day?.temperatureMin?.get(position)


        holder.itemView.item_desc.text = "Day: ${dayPhrase}, Night: ${nightPhrase}, MaxTemp: ${maxTemp} MinTemp: ${minTemp}"


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_weather, parent, false)

        return WeatherDataHolder(view)
    }

    override fun getItemCount(): Int = v3Agg.v3WxConditionsHistoricalDailysummary30day?.dayOfWeek?.size
            ?: 0


    class WeatherDataHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    }
}