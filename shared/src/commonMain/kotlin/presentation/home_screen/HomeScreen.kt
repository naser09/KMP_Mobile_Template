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

object HomeScreen :Screen{
    val title="Home"
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<HomeScreenViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        Column (modifier = Modifier.fillMaxSize()){
            Text(viewModel.seconds.value.toString())
            Button(onClick = { viewModel.startCoroutine() }){
                Text("Start")
            }
            Button(onClick = {viewModel.stopCoroutine() }){
                Text("Stop")
            }
            Button(onClick = {
                navigator.push(DetailsScreen())
                viewModel.onDispose()
            }){
                Text("navigate")
            }
        }
    }
}