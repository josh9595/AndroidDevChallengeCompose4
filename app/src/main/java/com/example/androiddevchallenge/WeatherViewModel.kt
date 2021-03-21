package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.ForecastHour

class WeatherViewModel() : ViewModel() {

    private val _selectedDayList = MutableLiveData(listOf<String>())
    val selectedDayList: LiveData<List<String>> = _selectedDayList

    private val _selectedHoursList = MutableLiveData(listOf<List<ForecastHour>>())
    val selectedHoursList: LiveData<List<List<ForecastHour>>> = _selectedHoursList

    fun initLists(pages: Int) {
        _selectedDayList.value = List(pages) { "" }
        _selectedHoursList.value = List(pages) { emptyList() }
    }

    fun setSelectedDay(position: Int, day: String) {
        val mutableList = _selectedDayList.value as MutableList
        if (mutableList[position] == day) {
            mutableList[position] = ""
        } else {
            mutableList[position] = day
        }

        _selectedDayList.value = mutableList
    }

    fun setSelectedDayHours(position: Int, hours: List<ForecastHour>) {
        val mutableList = _selectedHoursList.value as MutableList
        mutableList[position] = hours
        _selectedHoursList.value = mutableList
    }
}