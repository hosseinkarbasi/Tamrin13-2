package com.example.a100imagewithretrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkManager {

    val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(getLogging())
            .build()
    }

    private fun getLogging(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.flickr.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create(GitHubService::class.java)

}