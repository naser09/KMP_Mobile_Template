package di

import com.kmp.KMP_DB
import org.koin.dsl.module

internal val coreModule = module {
    single {
        KMP_DB(get())
    }
}