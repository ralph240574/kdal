package com.weather.sample.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weather.android.kdal.app.R
import com.weather.android.kdal.model.V3WxForecastDaily


class DailyRecyclerViewAdapter(private val v3WxForecastDaily: V3WxForecastDaily) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_header_daily, parent, false)
            return HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_item_daily, parent, false)
            return ItemViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else TYPE_ITEM
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val adjPos = position - 1


        val dayIndex = adjPos * 2
        val nightIndex = (adjPos * 2) + 1
        if (holder is ItemViewHolder) {
            val daypart = v3WxForecastDaily.daypart[0]
            formatText(holder.day, "%s", daypart.daypartName[dayIndex])
            formatText(holder.night, "%s", daypart.daypartName[nightIndex])

            formatText(holder.dayCond, "%d", daypart.iconCode[dayIndex])
            formatText(holder.nightCond, "%d", daypart.iconCode[nightIndex])

            formatText(holder.dayTemp, "%d F", daypart.temperature[dayIndex])
            formatText(holder.nightTemp, "%d F", daypart.temperature[nightIndex])

            val dayDir = daypart.windDirectionCardinal[dayIndex]
            val daySpeed = daypart.windSpeed[dayIndex]
            formatText(holder.dayWind, "%1\$s %2\$d MPH", dayDir, daySpeed)

            val nightDir = daypart.windDirectionCardinal[nightIndex]
            val nightSpeed = daypart.windSpeed[nightIndex]
            formatText(holder.nightWind, "%1\$s %2\$d MPH", nightDir, nightSpeed)
        }
    }

    fun formatText(textView: TextView, text: String, vararg s: Any?) {
        if (!s.isEmpty()) {
            textView.visibility = View.VISIBLE
            textView.text = String.format(text, *s)
        } else {
            textView.text = ""
            textView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return v3WxForecastDaily.daypart[0].daypartName.size + 1
    }

    class ItemViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val day: TextView
        val dayCond: TextView
        val dayTemp: TextView
        val dayWind: TextView
        val night: TextView
        val nightCond: TextView
        val nightTemp: TextView
        val nightWind: TextView

        init {
            day = mView.findViewById<View>(R.id.day) as TextView
            dayCond = mView.findViewById<View>(R.id.day_cond) as TextView
            dayTemp = mView.findViewById<View>(R.id.day_temp) as TextView
            dayWind = mView.findViewById<View>(R.id.day_wind) as TextView
            night = mView.findViewById<View>(R.id.night) as TextView
            nightCond = mView.findViewById<View>(R.id.night_cond) as TextView
            nightTemp = mView.findViewById<View>(R.id.night_temp) as TextView
            nightWind = mView.findViewById<View>(R.id.night_wind) as TextView
        }
    }


    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {

        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 1
    }
}
