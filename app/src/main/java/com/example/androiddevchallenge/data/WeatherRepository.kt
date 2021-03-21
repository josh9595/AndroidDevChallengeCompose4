package com.example.androiddevchallenge.data

import java.util.*

class WeatherRepository {
    fun getForecasts(): List<Forecast> = listOf(
        Forecast(
            "Manchester",
            ForecastOverview(
                10,
                13,
                6,
                Weather.HEAVY_RAIN
            ),
            listOf(
                ForecastHour(
                    "06:00",
                    8,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "07:00",
                    8,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "08:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "09:00",
                    9,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "10:00",
                    10,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "11:00",
                    11,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "12:00",
                    12,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "13:00",
                    12,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.HEAVY_RAIN
                ),
                ForecastHour(
                    "17:00",
                    13,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "18:00",
                    12,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "19:00",
                    11,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "20:00",
                    11,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "21:00",
                    10,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "22:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "23:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "00:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "01:00",
                    9,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "02:00",
                    9,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "03:00",
                    9,
                    Weather.HEAVY_CLOUD
                ),
                ForecastHour(
                    "04:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
                ForecastHour(
                    "05:00",
                    9,
                    Weather.LIGHT_RAIN
                ),
            )
        ),
        Forecast(
            "Los Angeles",
            ForecastOverview(
                10,
                13,
                6,
                Weather.CLEAR
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "London",
            ForecastOverview(
                10,
                13,
                6,
                Weather.LIGHT_RAIN
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Stuttgart",
            ForecastOverview(
                10,
                13,
                6,
                Weather.THUNDERSTORM
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Tokyo",
            ForecastOverview(
                10,
                13,
                6,
                Weather.HAIL
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Toronto",
            ForecastOverview(
                10,
                13,
                6,
                Weather.SNOW
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Sydney",
            ForecastOverview(
                10,
                13,
                6,
                Weather.LIGHT_CLOUD
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Helsinki",
            ForecastOverview(
                10,
                13,
                6,
                Weather.SLEET
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "Singapore",
            ForecastOverview(
                10,
                13,
                6,
                Weather.SHOWERS
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
        Forecast(
            "New York",
            ForecastOverview(
                10,
                13,
                6,
                Weather.HEAVY_CLOUD
            ),
            listOf(
                ForecastHour(
                    "09:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "10:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "11:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "12:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "13:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "14:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "15:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "16:00",
                    13,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "17:00",
                    12,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "18:00",
                    10,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "19:00",
                    9,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "20:00",
                    8,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "21:00",
                    7,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "22:00",
                    6,
                    Weather.CLEAR
                ),
                ForecastHour(
                    "23:00",
                    6,
                    Weather.CLEAR
                )
            )
        ),
    )
}