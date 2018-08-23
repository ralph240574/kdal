package com.weather.android.kdal.network

import com.weather.android.kdal.Units
import com.weather.android.kdal.model.V3Agg
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.*


internal interface V3AggInterface {

    @Headers("Cache-Control: max-age=0")
    @GET("v3/aggcommon/{path}?format=json")
    fun getV3AggFromNetwork(@Path("path") path: String,
                            @Query("language") language: String?,
                            @Query("date") date: String?,
                            @Query("scale") scale: String?,
                            @Query("geocode") geocode: String,
                            @Query("units") unit: Units?)
            : Single<Result<V3Agg>>

    /**
     *  This is using Result<V3Agg>, so that the cached Date header can be read
     * */
    @GET("v3/aggcommon/{path}?format=json")
    fun getV3AggFromCache(@HeaderMap headers: Map<String, String>?,
                          @Path("path") path: String,
                          @Query("language") language: String?,
                          @Query("date") date: String?,
                          @Query("scale") scale: String?,
                          @Query("geocode") geocode: String,
                          @Query("units") unit: Units?)
            : Single<Result<V3Agg>>
}