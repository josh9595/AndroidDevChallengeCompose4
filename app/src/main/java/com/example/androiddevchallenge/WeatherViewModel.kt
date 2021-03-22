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
