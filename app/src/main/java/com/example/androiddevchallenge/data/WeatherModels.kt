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

class WeatherModels {
}

data class Forecast (
    val name: String,
    val overview: ForecastOverview,
    val days: List<ForecastDay>
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

enum class Weather(val colour: Color, val seaColour: Color, val graphic: Int, val icon: Int, val iconSmall: Int) {
    CLEAR (clearBackground, clearSea, R.drawable.clear_graphic, R.drawable.clear, R.drawable.clear_small),
    LIGHT_CLOUD (lightCloudBackground, lightCloudSea, R.drawable.light_cloud_graphic, R.drawable.clear, R.drawable.clear_small),
    HEAVY_CLOUD (heavyCloudBackground, heavyCloudSea, R.drawable.heavy_cloud_graphic, R.drawable.clear, R.drawable.clear_small),
    SHOWERS (showersBackground, showersSea, R.drawable.showers_graphic, R.drawable.clear, R.drawable.clear_small),
    LIGHT_RAIN (lightRainBackground, lightRainSea, R.drawable.light_rain_graphic, R.drawable.clear, R.drawable.clear_small),
    HEAVY_RAIN (heavyRainBackground, heavyRainSea, R.drawable.heavy_rain_graphic, R.drawable.clear, R.drawable.clear_small),
    THUNDERSTORM (thunderstormBackground, thunderstormSea, R.drawable.thunderstorm_graphic, R.drawable.clear, R.drawable.clear_small),
    HAIL (hailBackground, hailSea, R.drawable.hail_graphic, R.drawable.clear, R.drawable.clear_small),
    SLEET (sleetBackground, sleetSea, R.drawable.sleet_graphic, R.drawable.clear, R.drawable.clear_small),
    SNOW (snowBackground, snowSea, R.drawable.snow_graphic, R.drawable.clear, R.drawable.clear_small)
}