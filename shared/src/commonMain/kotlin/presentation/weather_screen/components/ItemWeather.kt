package presentation.weather_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.Weather

@Composable
fun ItemWeather(weather: Weather) {
    Card (modifier = Modifier.padding(4.dp).fillMaxWidth(),
        shape = RoundedCornerShape(20),
        backgroundColor = Color.LightGray){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Icon(modifier = Modifier.align(Alignment.CenterVertically).scale(2f), imageVector = Icons.Default.Home, contentDescription = null)
            Text(weather.temperature.toString()+"°", fontSize = 45.sp)
            }
            Text(weather.city, fontWeight = FontWeight.Bold)
            Text(weather.conditions)
        }
    }
}