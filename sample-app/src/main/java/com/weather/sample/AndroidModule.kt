package com.weather.sample

import android.content.Context
import com.weather.android.kdal.V3Repo
import com.weather.android.kdal.V3RepoImpl
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
        val apiKey = "8de2d8b3a93542c9a2d8b3a935a2c909"
        return V3RepoImpl.newV3Repo(
                apiKey = apiKey,
                cacheDir = application.cacheDir,
                baseUrl = "https://api.weather.com",
                logging = true)
    }
}
