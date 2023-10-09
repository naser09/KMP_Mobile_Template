package di

import data.repository.UserRepositoryImpl
import domain.repository.UserRepository
import org.koin.dsl.module

val  repositoryModule = module {
    factory <UserRepository>{
        UserRepositoryImpl(database = get())
    }
}