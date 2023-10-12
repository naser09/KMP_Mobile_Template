package domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("weather_responses")
    val weatherResponses: List<Weather>
)