package presentation.root

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.details_screen.DetailsScreen
import presentation.home_screen.HomeScreen
import presentation.list_screen.ListScreen
import presentation.weather_screen.WeatherScreen

@Composable
fun App() {
    MaterialTheme {
            Navigator(screen = HomeScreen,
                onBackPressed = {
                    println("Back pressed")
                    true
                }) { navigator ->
                DefaultScafold(
                    title = when(navigator.lastItem){
                        is HomeScreen->HomeScreen.title
                        is DetailsScreen->DetailsScreen.title
                        is ListScreen -> ListScreen.title
                        is WeatherScreen-> "Weather From json response"
                        else -> "Unknown"
                    }, backIcon = {
                        if (navigator.canPop){
                            IconButton(onClick = {navigator.pop()}){
                                Icon(Icons.Default.ArrowBack,null)
                            }
                        }
                    }
                ) {
                    SlideTransition(
                        navigator = navigator,
                        modifier = Modifier.fillMaxWidth(),
                        animationSpec = tween(1000),
                        content = {
                            it.Content()
                        }
                    )
                }
            }
    }
}

@Composable
fun DefaultScafold(title:String,backIcon:@Composable ()->Unit,content: @Composable ()->Unit) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(modifier = Modifier.fillMaxWidth().height(75.dp),
                title = { Text(title) },
                navigationIcon = {backIcon()},
                backgroundColor = MaterialTheme.colors.primary)
        }
    ){
        content()
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun OldApp() {
    var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource(res = "th.jpeg"),
                    null
                )
            }
        }
}