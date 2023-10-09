package presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import korlibs.io.async.delay
import korlibs.io.async.launch
import korlibs.time.TimeSpan
import kotlinx.coroutines.Job

class HomeScreenViewModel :ScreenModel{
    private var job:Job? = null
    val seconds = mutableStateOf(0)
    fun startCoroutine(){
        job = coroutineScope.launch {
            while (true){
                delay(TimeSpan(1000.0))
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