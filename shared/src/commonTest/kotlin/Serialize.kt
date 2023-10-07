import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializeTest(){
    @Test
    fun test(){
    val obj = DataToSerialize("abu naser",26)
        val stringJson = Json.encodeToString(obj)
        println("Json string : $stringJson")
        assertEquals(obj,Json.decodeFromString(stringJson))
    }
}