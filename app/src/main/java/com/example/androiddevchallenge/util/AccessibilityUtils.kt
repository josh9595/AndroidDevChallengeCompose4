package com.example.androiddevchallenge.util

import android.content.Context
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Forecast

class AccessibilityUtils (private val context: Context) {
    fun buildForecastOverview(
        forecast: Forecast,
        date: String
    ): String {
        val temperatureString = context.getString(
            R.string.a11y_forecast_temperature,
            intToDegrees(forecast.overview.temp),
            forecast.overview.tempHigh.toString(),
            forecast.overview.tempLow.toString()
        )
        val weatherString = context.getString(R.string.a11y_forecast_weather, forecast.overview.weather.text)
        val weatherExtraString = calculateWeatherExtraString()

        return "$temperatureString $weatherString $weatherExtraString"
    }

    fun intToDegrees (temp: Int): String = context.getString(R.string.a11y_forecast_degrees, temp.toString())

    private fun calculateWeatherExtraString(): String {
        return context.getString(R.string.a11y_forecast_weather_same)
    }
}
