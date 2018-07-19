package com.weather.sample.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3WxForecastHourly10day
import java.text.SimpleDateFormat
import java.util.*


class HourlyRecyclerViewAdapter(private val v3WxForecastHourly10day: V3WxForecastHourly10day)//        TimeZone tz = DateParser.getTimeZone(v3WxForecastHourly10day.get(0));
//        dateFormat.setTimeZone(tz);
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val dateFormat = SimpleDateFormat("HH:mm", Locale.US)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_header_hourly, parent, false)
            return HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_item_hourly, parent, false)
            return ItemViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HourlyRecyclerViewAdapter.ItemViewHolder) {
            val adjPos = position - 1
//            Date time = DateParser.parse(v3WxForecastHourly10day.processTime.get(adjPos));

            //            itemViewHolder.time.setText(dateFormat.format(time));

            val cond = v3WxForecastHourly10day.iconCode[adjPos]
            holder.cond.text = "$cond"

            val temp = v3WxForecastHourly10day.temperature[adjPos]
            holder.temp.text = "$temp F"

            val precip = v3WxForecastHourly10day.precipChance[adjPos]
            holder.precip.text = "$precip%"
            val wind = v3WxForecastHourly10day.windSpeed[adjPos]
            val dir = v3WxForecastHourly10day.windDirectionCardinal[adjPos]

            holder.wind.text = "$dir $wind MPH"
        }
    }

    override fun getItemCount(): Int {
        return v3WxForecastHourly10day.dayOfWeek.size
    }

    class ItemViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val time: TextView
        val cond: TextView
        val temp: TextView
        val precip: TextView
        val wind: TextView


        init {
            time = mView.findViewById<View>(R.id.time) as TextView
            cond = mView.findViewById<View>(R.id.cond) as TextView
            temp = mView.findViewById<View>(R.id.temp) as TextView
            precip = mView.findViewById<View>(R.id.precip) as TextView
            wind = mView.findViewById<View>(R.id.wind) as TextView
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {

        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 1
    }
}
