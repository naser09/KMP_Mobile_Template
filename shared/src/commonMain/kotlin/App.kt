import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import presentation.home_screen.HomeScreen

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
//        Navigator(HomeScreen)
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
            var string by remember { mutableStateOf("value : 00") }
            var pagerstete = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) {
                10
            }
            LaunchedEffect(Unit){
                while (true){
                    delay(1000)
                    val page = if (pagerstete.currentPage+1>pagerstete.pageCount-1) 0 else pagerstete.currentPage+1
                    println("page = $page")
                    pagerstete.animateScrollToPage(page)
                }
            }
            HorizontalPager(
                state = pagerstete,
            ){page ->

                Box(Modifier.fillMaxWidth().height(45.dp).background(Color.Gray)){
                    Text("Current page $page", color = Color.White)
                }
            }
            Row {
                for (i in 0..<pagerstete.pageCount){
                    Box(Modifier.size(8.dp).clip(CircleShape).background(
                        if (pagerstete.currentPage==i) Color.Blue else Color.Gray
                    ))
                    Spacer(Modifier.width(3.dp).height(2.dp))
                }
            }
            Navigator(screen = HomeScreen,
                onBackPressed = {
                println("Back pressed")
                true }){ navigator ->
                SlideTransition(
                    navigator = navigator,
                    modifier = Modifier.fillMaxWidth(),
                    animationSpec = tween(2000),
                    content = {
                        println(it.key)
                        it.Content()
                    }

                )
            }
        }
    }
}

expect fun getPlatformName(): String


