package com.example.androiddevchallenge.data

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

enum class Weather {
    CLEAR,
    LIGHT_CLOUD,
    HEAVY_CLOUD,
    SHOWERS,
    LIGHT_RAIN,
    HEAVY_RAIN,
    THUNDERSTORM,
    HAIL,
    SLEET,
    SNOW
}