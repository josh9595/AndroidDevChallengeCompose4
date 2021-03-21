package com.example.androiddevchallenge.data

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.clearBackground
import com.example.androiddevchallenge.ui.theme.clearSea
import com.example.androiddevchallenge.ui.theme.hailBackground
import com.example.androiddevchallenge.ui.theme.hailSea
import com.example.androiddevchallenge.ui.theme.heavyCloudBackground
import com.example.androiddevchallenge.ui.theme.heavyCloudSea
import com.example.androiddevchallenge.ui.theme.heavyRainBackground
import com.example.androiddevchallenge.ui.theme.heavyRainSea
import com.example.androiddevchallenge.ui.theme.lightCloudBackground
import com.example.androiddevchallenge.ui.theme.lightCloudSea
import com.example.androiddevchallenge.ui.theme.lightRainBackground
import com.example.androiddevchallenge.ui.theme.lightRainSea
import com.example.androiddevchallenge.ui.theme.showersBackground
import com.example.androiddevchallenge.ui.theme.showersSea
import com.example.androiddevchallenge.ui.theme.sleetBackground
import com.example.androiddevchallenge.ui.theme.sleetSea
import com.example.androiddevchallenge.ui.theme.snowBackground
import com.example.androiddevchallenge.ui.theme.snowSea
import com.example.androiddevchallenge.ui.theme.thunderstormBackground
import com.example.androiddevchallenge.ui.theme.thunderstormSea
import java.util.*

data class Forecast (
    val name: String,
    val overview: ForecastOverview,
    val hours: List<ForecastHour>
)

data class ForecastOverview (
    val temp: Int,
    val tempHigh: Int,
    val tempLow: Int,
    val weather: Weather
)

data class ForecastDay (
    val date: Date,
    val dateReadable: String,
    val forecastDateList: List<ForecastHour>,
)

data class ForecastHour (
    val time: String,
    val temp: Int,
    val weather: Weather
)

enum class Weather(val text: String, val colour: Color, val seaColour: Color, val graphic: Int, val icon: Int, val iconSmall: Int) {
    CLEAR ("Clear", clearBackground, clearSea, R.drawable.clear_graphic, R.drawable.clear, R.drawable.clear_small),
    LIGHT_CLOUD ("Light Cloud", lightCloudBackground, lightCloudSea, R.drawable.light_cloud_graphic, R.drawable.light_cloud, R.drawable.light_cloud_small),
    HEAVY_CLOUD ("Heavy Cloud", heavyCloudBackground, heavyCloudSea, R.drawable.heavy_cloud_graphic, R.drawable.heavy_cloud, R.drawable.heavy_cloud_small),
    SHOWERS ("Showers", showersBackground, showersSea, R.drawable.showers_graphic, R.drawable.showers, R.drawable.showers_small),
    LIGHT_RAIN ("Light Rain", lightRainBackground, lightRainSea, R.drawable.light_rain_graphic, R.drawable.light_rain, R.drawable.light_rain_small),
    HEAVY_RAIN ("Heavy Rain", heavyRainBackground, heavyRainSea, R.drawable.heavy_rain_graphic, R.drawable.heavy_rain, R.drawable.heavy_rain_small),
    THUNDERSTORM ("Thunderstorms", thunderstormBackground, thunderstormSea, R.drawable.thunderstorm_graphic, R.drawable.thunderstorm, R.drawable.thunderstorm_small),
    HAIL ("Hail", hailBackground, hailSea, R.drawable.hail_graphic, R.drawable.hail, R.drawable.hail_small),
    SLEET ("Sleet", sleetBackground, sleetSea, R.drawable.sleet_graphic, R.drawable.sleet, R.drawable.sleet_small),
    SNOW ("Snow", snowBackground, snowSea, R.drawable.snow_graphic, R.drawable.snow, R.drawable.snow_small)
}