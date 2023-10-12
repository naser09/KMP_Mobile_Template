package presentation.weather_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import domain.model.Weather
import domain.use_cases.weather.GetWeather
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class WeatherScreenModel(
    private val getWeather: GetWeather
):ScreenModel {
    val weathers:MutableState<List<Weather>> = mutableStateOf(emptyList())
    init {
        collectWeather()
    }
    fun refreshWeather(){
        collectWeather()
    }
    private fun collectWeather(){
        coroutineScope.launch {
            getWeather().onEach { weatherList ->
                weathers.value = weatherList
            }.collect()
        }
    }
}