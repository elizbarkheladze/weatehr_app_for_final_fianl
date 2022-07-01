package com.exam.weather.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().url(
                    chain.request().url().newBuilder()
                        .addQueryParameter("appid", "7109dbedce09ad5b6dd0556aa8dbbeaa")
                        .build()
                ).build()
            )
        }.build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .build()

    fun apiService(): ApiService = retrofit.create(ApiService::class.java)
}
