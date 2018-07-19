package com.weather.sample

import android.content.Context
import com.weather.android.kdal.V3Repo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AndroidModule(private val application: DemoApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application
    }


    @Provides
    @Singleton
    fun providev3Repo(): V3Repo {
        val apiKey = "1941878e0eef4b4c81878e0eeffb4cc2"
        return V3Repo(
                apiKey = apiKey,
                cacheDir = application.cacheDir,
                baseUrl = "http://api.weather.com",
                loggingEnabled = true)
    }
}
