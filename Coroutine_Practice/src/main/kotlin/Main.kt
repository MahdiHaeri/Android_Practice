import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val answer = launch {
            println("Weather forecast")
            println(getWeatherReport())
        }
        launch {
            println("Have a good day!")
        }
        println("Hello World")
    }

}

suspend fun getWeatherReport() =  coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}
