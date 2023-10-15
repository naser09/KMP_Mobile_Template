package presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeScreenViewModel :ScreenModel{
    private var job:Job? = null

    fun slider(currentPage:Int,setPage:suspend(Int)->Unit,totalPage:Int,delay:Int){
        job = coroutineScope.launch {
            delay(delay.toLong())
            if (currentPage+1==totalPage){
                setPage(0)
            }else{
                setPage(currentPage+1)
            }
        }
    }

}