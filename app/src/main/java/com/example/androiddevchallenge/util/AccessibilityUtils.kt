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
        val weatherExtraString = calculateWeatherExtraString()

        return "$temperatureString $weatherString $weatherExtraString"
    }

    fun intToDegrees(temp: Int): String = context.getString(R.string.a11y_forecast_degrees, temp.toString())

    private fun calculateWeatherExtraString(): String {
        return context.getString(R.string.a11y_forecast_weather_same)
    }
}
