package di
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(){
     startKoin {
        modules(commonModule)
    }
}
val commonModule = module {
    includes(expectModule,coreModule, repositoryModule, useCasesModule, viewModelModule)
}