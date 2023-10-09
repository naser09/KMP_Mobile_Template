package di

import domain.use_cases.user.CreateUser
import domain.use_cases.user.GetUsers
import org.koin.dsl.module

val useCasesModule = module {
    factory { CreateUser(get()) }
    factory { GetUsers(get()) }
}