package presentation.home_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.Constant
import io.github.aakira.napier.Napier
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.delay
import presentation.home_screen.HomeScreenViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemAutoSlider(viewModel: HomeScreenViewModel) {
    val scope = rememberCoroutineScope()
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        val pagerstete = rememberPagerState() {
            Constant.imageUrlFromPexels.size
        }
        LaunchedEffect(pagerstete.settledPage){
            if (pagerstete.isScrollInProgress) return@LaunchedEffect
            delay(3000)
            val page = (pagerstete.currentPage+1) % pagerstete.pageCount
            Napier.d("page = $page")
            if (pagerstete.isScrollInProgress) return@LaunchedEffect
            pagerstete.animateScrollToPage(page)
        }
        HorizontalPager(
            state = pagerstete,
        ) { page ->
            Card(Modifier.fillMaxWidth().padding(6.dp).height(280.dp),
                shape = RoundedCornerShape(10)) {
                KamelImage(
                    asyncPainterResource(data = Constant.imageUrlFromPexels[page],
                        filterQuality = FilterQuality.Medium,
                        key = "imageFromPexels$page"
                    ), contentScale = ContentScale.FillWidth,
                    contentDescription = null)
                Box {
                    Text(modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .wrapContentHeight()
                        .padding(6.dp)
                        .background(brush = Brush.verticalGradient(listOf(Color.Transparent,Color.DarkGray,
                            Color.Black)))
                        ,
                        text = Constant.imageUrlFromPexels[page],
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)

                }
            }
        }
        Row {
            for (i in 0..<pagerstete.pageCount) {
                Box(
                    Modifier.size(8.dp).clip(CircleShape).background(
                        if (pagerstete.currentPage == i) Color.Blue else Color.Gray
                    )
                )
                Spacer(Modifier.width(3.dp).height(2.dp))
            }
        }
    }
}