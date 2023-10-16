package di

import data.repository.UserRepositoryImpl
import data.repository.WeatherRepositoryImpl
import domain.repository.UserRepository
import domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

internal val repositoryModule = module {
    factory <UserRepository>{
        UserRepositoryImpl(database = get())
    }
    factory <WeatherRepository>{
        WeatherRepositoryImpl(get(),get())
    }
}