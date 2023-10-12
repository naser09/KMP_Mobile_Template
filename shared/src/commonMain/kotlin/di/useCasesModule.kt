package di

import domain.use_cases.user.CreateUser
import domain.use_cases.user.GetUsers
import domain.use_cases.weather.GetWeather
import org.koin.dsl.module

internal val useCasesModule = module {
    factory { CreateUser(get()) }
    factory { GetUsers(get()) }
    factory { GetWeather(get()) }
}