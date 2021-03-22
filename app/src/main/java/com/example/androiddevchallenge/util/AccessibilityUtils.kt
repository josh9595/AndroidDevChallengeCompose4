/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.util

import android.content.Context
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Forecast
import com.example.androiddevchallenge.data.ForecastHour
import com.example.androiddevchallenge.data.Weather

class AccessibilityUtils(private val context: Context) {
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
        val weatherExtraString = calculateWeatherExtraString(forecast.hours)

        return "$temperatureString $weatherString $weatherExtraString"
    }

    fun intToDegrees(temp: Int): String = context.getString(R.string.a11y_forecast_degrees, temp.toString())

    private fun calculateWeatherExtraString(overviewForecast: String, hours: List<ForecastHour>): String {
        var list = mutableListOf(
            Pair(Weather.CLEAR, 0),
            Pair(Weather.LIGHT_CLOUD, 0),
            Pair(Weather.HEAVY_CLOUD, 0),
            Pair(Weather.SHOWERS, 0),
            Pair(Weather.LIGHT_RAIN, 0),
            Pair(Weather.HEAVY_RAIN, 0),
            Pair(Weather.THUNDERSTORM, 0),
            Pair(Weather.HAIL, 0),
            Pair(Weather.SLEET, 0),
            Pair(Weather.SNOW, 0)
        )
//        hours.forEach { hour ->
//            list.find { it.first ==  hour.weather }.second++
//        }
        return context.getString(R.string.a11y_forecast_weather_same)
    }
}
