package com.exam.weather.retrofit

import com.exam.weather.retrofit.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    fun fetchWeather(
        @Query("q") location: String,
    ): Call<WeatherResponse>
}
