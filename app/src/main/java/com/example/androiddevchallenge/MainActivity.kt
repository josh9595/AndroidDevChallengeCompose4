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

import android.os.Bundle
import android.text.format.DateFormat
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.data.Forecast
import com.example.androiddevchallenge.data.ForecastDay
import com.example.androiddevchallenge.data.ForecastHour
import com.example.androiddevchallenge.data.WeatherRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.selectedBackground
import com.example.androiddevchallenge.ui.theme.transparentBackground
import com.example.androiddevchallenge.util.AccessibilityUtils
import com.example.androiddevchallenge.util.Pager
import com.example.androiddevchallenge.util.PagerState
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val forecasts = WeatherRepository().getForecasts()
        val accessibilityUtils = AccessibilityUtils(this)

        setContent {
            MyTheme {
                ProvideWindowInsets {
                    MyApp(
                        forecasts,
                        accessibilityUtils
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(
    forecasts: List<Forecast>,
    accessibilityUtils: AccessibilityUtils,
    weatherViewModel: WeatherViewModel = WeatherViewModel()
) {
    weatherViewModel.initLists(forecasts.size)

    val pagerState = remember { PagerState() }
    val selectedBackground = forecasts[pagerState.currentPage].overview.weather.colour
    val selectedSea = forecasts[pagerState.currentPage].overview.weather.seaColour

    val selectedDayState: List<String> by weatherViewModel.selectedDayList.observeAsState(List(forecasts.size) { "" })
    val selectedHoursState: List<List<ForecastHour>> by weatherViewModel.selectedHoursList.observeAsState(List(forecasts.size) { emptyList() })

    pagerState.maxPage = (forecasts.size - 1).coerceAtLeast(0)

    Surface(color = animateColorAsState(
        selectedBackground,
        spring(stiffness = Spring.StiffnessVeryLow)
    ).value) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    animateColorAsState(
                        selectedSea,
                        spring(stiffness = Spring.StiffnessLow)
                    ).value
                )) {

            }
            Pager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                WeatherPageItem(
                    forecasts[page],
                    accessibilityUtils
                )
            }
        }
    }
}

@Composable
fun WeatherPageItem(
    forecast: Forecast,
    accessibilityUtils: AccessibilityUtils,
) {
    val date = DateFormat.format("EEEE, d MMMM yyyy", Date()).toString()
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = forecast.overview.weather.graphic),
            contentDescription = null,
            contentScale = FillWidth,
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.BottomCenter
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Column(Modifier.semantics(true) {
                contentDescription = accessibilityUtils.buildForecastOverview(
                    forecast,
                    date,
                )
            }) {
                Row(modifier = Modifier.padding(16.dp, 32.dp, 16.dp, 0.dp)) {
                    Text(text = forecast.name, style = MaterialTheme.typography.h2)
                }

                Row(modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = forecast.overview.temp.toString()+"°", style = MaterialTheme.typography.h1)
                    Column(Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)) {
                        Row {
                            Icon(
                                Icons.Default.ArrowUpward,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
                                    .width(28.dp),
                                tint = Color.White
                            )
                            Text(text = forecast.overview.tempHigh.toString()+"°", style = MaterialTheme.typography.h3)
                        }
                        Row {
                            Icon(
                                Icons.Default.ArrowDownward,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
                                    .width(28.dp),
                                tint = Color.White
                            )
                            Text(text = forecast.overview.tempLow.toString()+"°", style = MaterialTheme.typography.h3)
                        }

                    }
                    Image(painter = painterResource(id = forecast.overview.weather.icon), contentDescription = null, modifier = Modifier.size(120.dp))
                }
            }

            Text(
                text = date,
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp).semantics {
                    contentDescription = "Hourly forecast for $date"
                }
            )

            LazyRow (
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)){
                itemsIndexed (forecast.days[0].forecastDateList) { index, hour ->
                    HourForecast(
                        hour,
                        index + 1,
                        forecast.days[0].forecastDateList.size,
                        accessibilityUtils
                    )
                }
            }
        }
    }
}

@Composable
fun HourForecast(
    hour: ForecastHour,
    position: Int,
    size: Int,
    accessibilityUtils: AccessibilityUtils
) {
    Column(modifier = Modifier
        .width(50.dp)
        .semantics(true) {
            contentDescription = "${hour.time}, ${hour.weather.text}, ${accessibilityUtils.intToDegrees(hour.temp)}, $position of $size"
        }
    ) {
        Text(
            text = hour.temp.toString()+"°",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = hour.weather.iconSmall),
            contentDescription = null,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = hour.time,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
//        MyApp(WeatherRepository().getForecasts(), {})
    }
}
