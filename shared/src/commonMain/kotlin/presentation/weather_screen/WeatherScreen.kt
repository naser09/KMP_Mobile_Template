package presentation.weather_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import presentation.weather_screen.components.ItemWeather

object WeatherScreen :Screen{
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<WeatherScreenModel>()

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(viewModel.weathers.value){
                ItemWeather(it)
            }
        }
    }

}