package di

import app.cash.sqldelight.ColumnAdapter
import com.kmp.KMP_DB
import com.kmp.Weather_entity
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

internal val coreModule = module {
    single {
        val adapter = object :ColumnAdapter<Double,String>{
            override fun decode(databaseValue: String): Double {
                return databaseValue.toDoubleOrNull()?:0.0
            }

            override fun encode(value: Double): String {
                return value.toString()
            }
        }
        KMP_DB(get(), weather_entityAdapter = Weather_entity.Adapter(adapter,adapter))
    }
    single <HttpClient>{
        HttpClient {
            install(ContentNegotiation){
                json()
            }
        }
    }
}