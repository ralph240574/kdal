package com.weather.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.weather.android.kdal.app.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = SlidingTabsFragment()
            transaction.replace(R.id.sample_content_fragment, fragment)
            transaction.commit()

        }

    }


    companion object {

        val TAG = "MainActivity"
    }


}



