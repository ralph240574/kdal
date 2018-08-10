package com.weather.android.kdal.network

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

val LOGGING: okhttp3.Interceptor = Interceptor { chain ->
    val request = chain.request()

    val t1 = System.nanoTime()
    println(String.format(Locale.US, "Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()))

    val response = chain.proceed(request)

    val t2 = System.nanoTime()
    println(String.format(Locale.US, "Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6, response.headers()))

    response
}


internal class ApiKeyInterceptor(private val queryParameterForApiKey: String, private val apiKey: String) : okhttp3.Interceptor {


    constructor(v3ApiKey: String) : this("apiKey", v3ApiKey) {}

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val url = originalRequest.url()
                .newBuilder()
                .addQueryParameter(queryParameterForApiKey, apiKey)
                .build()

        val request = originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}

internal class RewriteResponse(private val maxCacheAgeInSec: Int) : okhttp3.Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        return originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$maxCacheAgeInSec")
                //remove all cache control headers that could interfere with caching
                .removeHeader("Pragma")
                .removeHeader("Expires")
                .build()
    }
}


interface HeadersInterceptor {
    fun onResponse(headers: Headers)
}