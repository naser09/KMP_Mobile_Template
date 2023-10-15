package presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.details_screen.DetailsScreen
import presentation.home_screen.components.ItemAutoSlider
import presentation.weather_screen.WeatherScreen

object HomeScreen :Screen{
    val title="Home"
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<HomeScreenViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        Column (modifier = Modifier.fillMaxSize()){
            ItemAutoSlider(viewModel)
            Button(onClick = {
                navigator.push(DetailsScreen())
            }){
                Text("navigate")
            }
            Button(onClick = {
                navigator.push(WeatherScreen)
            }){
                Text("navigate to weather")
            }
        }
    }
}