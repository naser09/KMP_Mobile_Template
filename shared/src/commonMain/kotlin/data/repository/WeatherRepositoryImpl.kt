package data.repository

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

class WeatherRepositoryImpl(private val httpClient: HttpClient):WeatherRepository {
    override fun getWeather(): Flow<List<Weather>> {
        return flow {
            val response = httpClient.get(Constant.JSON_TEST_FILE_LINK)
            try {
                println(response.bodyAsText())
                emit(response.body<Response>().weatherResponses)
            }catch (ex:NoTransformationFoundException){
                println("Not the data i wanted !")
            }catch (ex:Exception){
                emit(emptyList())
                println("Something else ${ex.message}")
            }
        }
    }
}