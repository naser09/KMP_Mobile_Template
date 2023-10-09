package presentation.details_screen

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import domain.model.User
import domain.use_cases.user.CreateUser
import domain.use_cases.user.GetUsers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val createUser: CreateUser,
    private val getUsers: GetUsers
):ScreenModel{
    val users = mutableStateOf(listOf<User>())
    fun createUser(name:String){
        createUser(User(id = 0, name = name))
    }
    init {
        coroutineScope.launch {
            getUsers().onEach {
                users.value = it
            }.collect()
        }
    }
}