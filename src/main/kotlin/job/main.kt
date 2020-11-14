package job

import kotlinx.coroutines.*
import kotlin.time.seconds

suspend fun main() {
    val job = GlobalScope.launch {
        launch {
            delay(1.seconds)
            println(1)
        }
        launch {
            delay(1.seconds)
            println(2)
        }
    }
    job.join()
}

suspend fun example() {
    coroutineScope {
        val request = launch {
            GlobalScope.launch {
                println("job1: I run in GlobalScope and execute independently!")
                delay(1000)
                println("job1: I am not affected by cancellation of the request")
            }

            launch {
                delay(100)
                println("job2: I am a child of the request coroutine")
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled")
            }
        }
        delay(500)
        request.cancel()
        delay(1000)
        println("main: Who has survived request cancellation?")
    }
}