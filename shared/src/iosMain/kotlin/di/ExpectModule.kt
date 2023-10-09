package di

import app.cash.sqldelight.db.SqlDriver
import data.database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val expectModule:Module = module {
    single <SqlDriver>{ DriverFactory().createDriver() }
}