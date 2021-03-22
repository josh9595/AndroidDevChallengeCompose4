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
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.data.Forecast
import com.example.androiddevchallenge.data.ForecastHour
import com.example.androiddevchallenge.data.WeatherRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.seaColor
import com.example.androiddevchallenge.util.AccessibilityUtils
import com.example.androiddevchallenge.util.Pager
import com.example.androiddevchallenge.util.PagerState
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

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
    accessibilityUtils: AccessibilityUtils
) {
    val pagerState = remember { PagerState() }
    val coroutineScope = rememberCoroutineScope()

    val selectedBackground = forecasts[pagerState.currentPage].overview.weather.colour

    val infiniteTransition = rememberInfiniteTransition()
    val paddingAnim by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = if (accessibilityUtils.screenReaderEnabled()) 0f else 32f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    pagerState.maxPage = (forecasts.size - 1).coerceAtLeast(0)

    Surface(
        color = animateColorAsState(
            selectedBackground,
            spring(stiffness = Spring.StiffnessVeryLow)
        ).value
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(0.dp, 32.dp, 0.dp, 0.dp)
                    .zIndex(2f)
            ) {
                if (pagerState.currentPage != 0) {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.goToPage(pagerState.currentPage - 1)
                            }
                        },
                        modifier = Modifier
                            .padding(0.dp, 14.dp, 0.dp, 0.dp)
                            .width(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronLeft,
                            contentDescription = "Go to ${forecasts[pagerState.currentPage - 1].name} forecast",
                            tint = Color.White
                        )
                    }
                } else {
                    Spacer(Modifier.width(48.dp))
                }
                Text(
                    text = forecasts[pagerState.currentPage].name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription =
                                "Forecast for ${forecasts[pagerState.currentPage].name}"
                            heading()
                        }
                        .focusModifier(),
                    textAlign = TextAlign.Center
                )
                if (pagerState.currentPage != forecasts.size - 1) {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.goToPage(pagerState.currentPage + 1)
                            }
                        },
                        modifier = Modifier
                            .padding(0.dp, 14.dp, 0.dp, 0.dp)
                            .width(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Go to ${forecasts[pagerState.currentPage + 1].name} forecast",
                            tint = Color.White
                        )
                    }
                } else {
                    Spacer(Modifier.width(48.dp))
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(
                            seaColor
                        )
                ) {
                }
                Pager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    WeatherPageItem(
                        page,
                        forecasts,
                        paddingAnim,
                        accessibilityUtils
                    )
                }
            }
        }
    }
}

@Composable
fun WeatherPageItem(
    page: Int,
    forecasts: List<Forecast>,
    paddingAnim: Float,
    accessibilityUtils: AccessibilityUtils,
) {

    val date = DateFormat.format("EEEE, d MMMM yyyy", Date()).toString()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 104.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource(id = forecasts[page].overview.weather.graphic),
            contentDescription = null,
            contentScale = FillWidth,
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.BottomStart
        )
        Image(
            painter = painterResource(R.drawable.fishing_line),
            contentDescription = null,
            modifier = Modifier.padding((paddingAnim + 16).dp, 0.dp, 0.dp, 120.dp),
            alignment = Alignment.BottomStart
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier.semantics(true) {
                    contentDescription = accessibilityUtils.buildForecastOverview(
                        forecasts[page],
                        date,
                    )
                }
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = forecasts[page].overview.temp.toString() + "°", style = MaterialTheme.typography.h1)
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
                            Text(text = forecasts[page].overview.tempHigh.toString() + "°", style = MaterialTheme.typography.h3)
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
                            Text(text = forecasts[page].overview.tempLow.toString() + "°", style = MaterialTheme.typography.h3)
                        }
                    }
                    Image(
                        painter = painterResource(id = forecasts[page].overview.weather.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(0.dp, 16.dp, 0.dp, 0.dp)
                    )
                }
            }

            Text(
                text = date,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 0.dp, 8.dp)
                    .semantics {
                        contentDescription = "Hourly forecast for $date"
                    }
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
            ) {
                itemsIndexed(forecasts[page].hours) { index, hour ->
                    HourForecast(
                        hour,
                        index + 1,
                        forecasts[page].hours.size,
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
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, 1)
    val tomorrow = calendar.time

    Column(
        modifier = Modifier
            .width(50.dp)
            .semantics(true) {
                contentDescription =
                    "${hour.time}, ${hour.weather.text}, ${accessibilityUtils.intToDegrees(hour.temp)}, $position of $size"
            }
    ) {
        Text(
            text = hour.temp.toString() + "°",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = hour.weather.iconSmall),
            contentDescription = null,
            modifier = Modifier.height(50.dp)
        )
        Text(
            text = hour.time,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        if (hour.time == "00:00") {
            Text(
                text = DateFormat.format("EE", tomorrow).toString(),
                style = MaterialTheme.typography.body2,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
//        MyApp(WeatherRepository().getForecasts(), {})
    }
}
