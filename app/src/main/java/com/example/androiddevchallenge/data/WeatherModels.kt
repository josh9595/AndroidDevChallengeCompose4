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
package com.example.androiddevchallenge.data

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.clearBackground
import com.example.androiddevchallenge.ui.theme.hailBackground
import com.example.androiddevchallenge.ui.theme.heavyCloudBackground
import com.example.androiddevchallenge.ui.theme.heavyRainBackground
import com.example.androiddevchallenge.ui.theme.lightCloudBackground
import com.example.androiddevchallenge.ui.theme.lightRainBackground
import com.example.androiddevchallenge.ui.theme.showersBackground
import com.example.androiddevchallenge.ui.theme.sleetBackground
import com.example.androiddevchallenge.ui.theme.snowBackground
import com.example.androiddevchallenge.ui.theme.thunderstormBackground
import java.util.*

data class Forecast(
    val name: String,
    val overview: ForecastOverview,
    val hours: List<ForecastHour>
)

data class ForecastOverview(
    val temp: Int,
    val tempHigh: Int,
    val tempLow: Int,
    val weather: Weather
)

data class ForecastDay(
    val date: Date,
    val dateReadable: String,
    val forecastDateList: List<ForecastHour>,
)

data class ForecastHour(
    val time: String,
    val temp: Int,
    val weather: Weather
)

enum class Weather(val text: String, val colour: Color, val graphic: Int, val icon: Int, val iconSmall: Int) {
    CLEAR("Clear", clearBackground, R.drawable.clear_graphic, R.drawable.clear, R.drawable.clear_small),
    LIGHT_CLOUD("Light Cloud", lightCloudBackground, R.drawable.light_cloud_graphic, R.drawable.light_cloud, R.drawable.light_cloud_small),
    HEAVY_CLOUD("Heavy Cloud", heavyCloudBackground, R.drawable.heavy_cloud_graphic, R.drawable.heavy_cloud, R.drawable.heavy_cloud_small),
    SHOWERS("Showers", showersBackground, R.drawable.showers_graphic, R.drawable.showers, R.drawable.showers_small),
    LIGHT_RAIN("Light Rain", lightRainBackground, R.drawable.light_rain_graphic, R.drawable.light_rain, R.drawable.light_rain_small),
    HEAVY_RAIN("Heavy Rain", heavyRainBackground, R.drawable.heavy_rain_graphic, R.drawable.heavy_rain, R.drawable.heavy_rain_small),
    THUNDERSTORM("Thunderstorms", thunderstormBackground, R.drawable.thunderstorm_graphic, R.drawable.thunderstorm, R.drawable.thunderstorm_small),
    HAIL("Hail", hailBackground, R.drawable.hail_graphic, R.drawable.hail, R.drawable.hail_small),
    SLEET("Sleet", sleetBackground, R.drawable.sleet_graphic, R.drawable.sleet, R.drawable.sleet_small),
    SNOW("Snow", snowBackground, R.drawable.snow_graphic, R.drawable.snow, R.drawable.snow_small)
}
