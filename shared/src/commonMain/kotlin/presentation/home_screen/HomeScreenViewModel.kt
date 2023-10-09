package presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeScreenViewModel :ScreenModel{
    private var job:Job? = null
    val seconds = mutableStateOf(0)
    fun startCoroutine(){
        job = coroutineScope.launch {
            while (true){
                delay(1000)
                seconds.value+=1
            }
        }
    }
    fun stopCoroutine(){
        job?.cancel()
        println("Cancaled ${job?.key}")
    }
    override fun onDispose() {
        super.onDispose()
        println("disposed")
        job?.cancel()
        println("job = ${job?.key}")
    }
}