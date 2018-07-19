package com.weather.android.kdal.network

import com.weather.android.kdal.Units
import com.weather.android.kdal.model.V3Agg
import io.reactivex.Single
import retrofit2.http.*


interface V3AggInterface {

    @Headers("Cache-Control: max-age=0")
    @GET("v3/aggcommon/{path}?format=json")
    fun getV3AggFromNetwork(@Path("path") path: String,
                            @Query("language") language: String?,
                            @Query("date") date: String?,
                            @Query("scale") scale: String?,
                            @Query("geocode") geocode: String,
                            @Query("units") units: Units?)
            : Single<V3Agg>

    @GET("v3/aggcommon/{path}?format=json")
    fun getV3AggFromCache(@HeaderMap headers: Map<String, String>?,
                          @Path("path") path: String,
                          @Query("language") language: String?,
                          @Query("date") date: String?,
                          @Query("scale") scale: String?,
                          @Query("geocode") geocode: String,
                          @Query("units") units: Units?)
            : Single<V3Agg>


}