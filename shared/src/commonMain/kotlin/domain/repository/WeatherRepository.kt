package domain.repository

import domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather():Flow<List<Weather>>
}