package presentation.weather_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import domain.model.Weather

@Composable
fun ItemWeather(weather: Weather) {
    Card (modifier = Modifier, shape = RoundedCornerShape(20)){
        Column {
            Row {
                Icon(Icons.Default.Home,null)
            Text(weather.temperature.toString()+"°", fontSize = 45.sp)
            }
            Text(weather.city, fontWeight = FontWeight.Bold)
            Text(weather.conditions)
        }
    }
}