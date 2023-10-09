package di

import data.database.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val expectModule:Module = module {
    single {
        DriverFactory(androidContext()).createDriver()
    }
}