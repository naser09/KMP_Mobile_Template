package data.repository

import com.kmp.KMP_DB
import core.Constant
import domain.model.Response
import domain.model.Weather
import domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class WeatherRepositoryImpl(private val httpClient: HttpClient,private val kmpDb: KMP_DB):WeatherRepository {
    private val weatherQueries = kmpDb.weatherEntiryQueries
    override fun getWeather(): Flow<List<Weather>> {
        return flow {
            val data = weatherQueries.get_weathers().executeAsList()
            emit(data.map {d-> Weather(d.city,d.conditions,d.humidity.toInt(),d.temperature,d.wind_speed) })
            try {
                val response = httpClient.get(Constant.JSON_TEST_FILE_LINK).body<Response>()
                response.weatherResponses.forEach {
                    it.run { weatherQueries.create_weather(city,conditions,humidity.toLong(),temperature,windSpeed) }
                }
                val newData = weatherQueries.get_weathers().executeAsList()
                emit(newData.map {d-> Weather(d.city,d.conditions,d.humidity.toInt(),d.temperature,d.wind_speed) })
            }catch (ex:NoTransformationFoundException){
                println("Not the data i wanted !")
            }catch (ex:Exception){
                emit(emptyList())
                println("Something else ${ex.message}")
            }
        }
    }
}