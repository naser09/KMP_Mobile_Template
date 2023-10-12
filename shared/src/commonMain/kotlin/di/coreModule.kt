package di

import com.kmp.KMP_DB
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

internal val coreModule = module {
    single {
        KMP_DB(get())
    }
    single <HttpClient>{
        HttpClient {
            install(ContentNegotiation){
                json()
            }
        }
    }
}