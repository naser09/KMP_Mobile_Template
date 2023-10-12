package domain.use_cases.weather

import domain.model.Weather
import domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetWeather(private val weatherRepository: WeatherRepository) {
    operator fun invoke():Flow<List<Weather>> = weatherRepository.getWeather()
}