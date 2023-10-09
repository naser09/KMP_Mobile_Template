package di

import org.koin.dsl.module
import presentation.details_screen.DetailsScreenViewModel
import presentation.home_screen.HomeScreenViewModel
import presentation.list_screen.ListScreenViewModel

val viewModelModule = module {
    factory { HomeScreenViewModel() }
    factory {
        DetailsScreenViewModel(get(),get())
    }
    factory {
        ListScreenViewModel(get())
    }
}