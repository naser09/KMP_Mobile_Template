package presentation.details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.list_screen.ListScreen

class DetailsScreen: Screen {
    companion object{
        val title = "Details Screen"
    }
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel:DetailsScreenViewModel = getScreenModel()
        val text = remember { mutableStateOf("") }
        Column (
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Text("Home Screen ${viewModel.users.value.size}")
            TextField(text.value, onValueChange = {text.value = it})

            Button(onClick = {
                viewModel.createUser(text.value)
            }){
                Text("Create User")
            }

            Button(onClick = {
                navigator.push(ListScreen(viewModel.users.value.map { it.name }))
            }){
                Text("Navigate")
            }
            Button(onClick = {
                navigator.popUntilRoot()
            }){
                Text("Back")
            }
            LazyColumn {
                items(viewModel.users.value){
                    Row {
                        Text("id:${it.id}")
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(it.name)
                    }
                }
            }
        }
    }

}