package default

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.seconds

suspend fun main() = coroutineScope {
    val jobs = (1..100_000).map {
        launch {
            delay(1.seconds)
            println(1)
        }
    }
    jobs.forEach { it.join() }
}