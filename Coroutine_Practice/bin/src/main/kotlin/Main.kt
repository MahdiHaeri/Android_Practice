import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            println("Weather forecast")
            println(getWeatherReport())
        }
        launch {
            println("Have a good day!")
        }

        delay(3000)
        println("Hello coroutines")
    }
}

suspend fun getWeatherReport() = coroutineScope {
    try {
        val forecast = async { getForecast() }
        val temperature = async { getTemperature() }
        "${forecast.await()} ${temperature.await()}"
    } catch (e: Exception) {
        println(e.message)
    }
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}
