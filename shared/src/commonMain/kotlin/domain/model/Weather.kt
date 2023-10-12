package domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("city")
    val city: String,
    @SerialName("conditions")
    val conditions: String,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("temperature")
    val temperature: Double,
    @SerialName("wind_speed")
    val windSpeed: Double
)