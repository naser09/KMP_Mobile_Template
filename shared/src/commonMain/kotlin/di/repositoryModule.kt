package di

import data.repository.UserRepositoryImpl
import domain.repository.UserRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    factory <UserRepository>{
        UserRepositoryImpl(database = get())
    }
}