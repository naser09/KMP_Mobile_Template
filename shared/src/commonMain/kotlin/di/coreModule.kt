package di

import data.database.SqliteDatabaseImpl
import org.koin.dsl.module

val coreModule = module {
    single {
        SqliteDatabaseImpl.database()
    }
}