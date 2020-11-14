package context

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

@ObsoleteCoroutinesApi
suspend fun main() {
    val context1 = newSingleThreadContext("ONE")
    val context2 = newSingleThreadContext("TWO")

    withContext(context1) {
        doStuff()

        withContext(context2) {
            doStuff()
        }

        doStuff()
    }
}

suspend fun doStuff() = println("Doing stuff in ${Thread.currentThread().name}")