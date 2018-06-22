package com.weather.sample

import android.app.Application


class DemoApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        val component = initDaggerComponent()
        component.inject(this)
        this.component = component
    }


    protected fun initDaggerComponent(): AppComponent {
        return DaggerAppComponent.builder().androidModule(AndroidModule(this)).build()
    }
}