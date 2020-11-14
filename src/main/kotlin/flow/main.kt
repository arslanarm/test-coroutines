package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    val list = flow {
        for (i in 1..3) {
            delay(100)
            emit(i)
        }


//        withContext(Dispatchers.IO) {
//            emit(10) // emit is prohibited, in situations like this you need to use channelFlow
//        }
    }

    list.collect {
        println(it)
    }

}

suspend fun example() {
    val list = channelFlow {
        send(1)
        withContext(Dispatchers.IO) {
            send(2)
        }
    }

    list.collect {
        println(it)
    }
}