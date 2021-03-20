package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.ForecastHour

class WeatherViewModel() : ViewModel() {
    private val _selectedForecast = MutableLiveData("")
    val selectedForecast: LiveData<String> = _selectedForecast

    private val _selectedDay = MutableLiveData("")
    val selectedDay: LiveData<String> = _selectedDay

    private val _selectedDayHours = MutableLiveData(listOf<ForecastHour>())
    val selectedDayHours: LiveData<List<ForecastHour>> = _selectedDayHours

    fun setSelectedDay(day: String) {
        if (_selectedDay.value == day){
            _selectedDay.value = ""
        } else {
            _selectedDay.value = day
        }
    }

    fun setSelectedDayHours(hours: List<ForecastHour>) {
        if (_selectedDay.value == ""){
            _selectedDayHours.value = emptyList()
        } else {
            _selectedDayHours.value = hours
        }
    }
}