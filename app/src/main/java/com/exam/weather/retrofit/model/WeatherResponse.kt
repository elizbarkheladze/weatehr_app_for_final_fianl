package com.exam.weather.retrofit.model

data class WeatherResponse(
    val name: String,
    val weather: List<WeatherDataResponse>,
    val main: WeatherTemperatureData
)