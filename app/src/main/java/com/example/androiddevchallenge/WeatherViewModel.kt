package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.ForecastHour

class WeatherViewModel() : ViewModel() {
    private val _selectedDay = MutableLiveData("Today")
    val selectedDay: LiveData<String> = _selectedDay

    private val _selectedDayHours = MutableLiveData(listOf<ForecastHour>())
    val selectedDayHours: LiveData<List<ForecastHour>> = _selectedDayHours

    fun setSelectedDay(day: String) {
        _selectedDay.value = day
    }

    fun setSelectedDayHours(hours: List<ForecastHour>) {
        _selectedDayHours.value = hours
    }
}