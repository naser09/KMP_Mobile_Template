package di

import app.cash.sqldelight.Query
import com.kmp.KMP_DB
import data.database.SqliteDatabase
import data.database.SqliteDatabaseImpl
import data.repository.UserRepositoryImpl
import domain.model.User
import domain.repository.UserRepository
import domain.use_cases.user.CreateUser
import domain.use_cases.user.GetUsers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.dsl.module
import presentation.details_screen.DetailsScreenViewModel
import presentation.home_screen.HomeScreenViewModel
import presentation.list_screen.ListScreenViewModel

val viewModelModule = module {
    factory { HomeScreenViewModel() }
    factory { SqliteDatabaseImpl.database() }
    factory <UserRepository>{
        UserRepositoryImpl(database = get())
    }
    factory { CreateUser(get()) }
    factory { GetUsers(get()) }
    factory {
        DetailsScreenViewModel(get(),get())
    }
    factory {
        ListScreenViewModel(get())
    }
}