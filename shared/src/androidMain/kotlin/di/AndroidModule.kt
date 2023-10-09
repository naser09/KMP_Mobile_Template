package di
import data.database.ContextHolder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single { ContextHolder(androidContext()) }
}
