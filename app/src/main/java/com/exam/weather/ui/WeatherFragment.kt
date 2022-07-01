package com.exam.weather.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.exam.weather.R
import com.exam.weather.retrofit.ApiClient
import com.exam.weather.retrofit.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal
import java.math.RoundingMode

class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var location: TextView
    private lateinit var background: ConstraintLayout
    private lateinit var temperature: TextView
    private var city: String = ""

    fun setCity(city: String) {
        this.city = city
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        background = view.findViewById(R.id.back_we)
        location = view.findViewById(R.id.location)
        temperature = view.findViewById(R.id.temperature)
        ApiClient.apiService().fetchWeather(city)
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    val body = response.body()
                    if (body != null) {
                        location.text = body.name
                        temperature.text = (body.main.temp - 273.15).toBigDecimal().setScale(2,
                            RoundingMode.UP).toString()
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {}
            })
    }
}
