import green.square.ExceptionSuccessfullyProcessedExceptionProvider
import green.square.GlobalCoroutineExceptionHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalCoroutineExceptionHandler.addCoroutineExceptionHandler(CoroutineExceptionHandler { _, _ ->
        throw ExceptionSuccessfullyProcessedExceptionProvider.get()
    })

    GlobalScope.launch { throw IllegalStateException() }.join()
    println("Program is working")
}