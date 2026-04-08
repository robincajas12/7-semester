package org.example
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() {

    coroutineScope {
        launch {
            greet();
            println("The withContext() on the thread: ${Thread.currentThread().name}")
            delay(5.seconds)
        }
        launch {
            println("The withContext() on the thread: ${Thread.currentThread().name}")
            delay(5.seconds)
        }
    }
    val name = "Kotlin"
    val list : List<Int> = listOf(1,2,3,5)
    println(Person(name, 4, listOf("a0")).login())
    println("Hello, " + name + "!")
    println(Thread.currentThread().name)
    println(5.hello())


}
suspend fun greet() {
    println("The greet() on the thread: ${Thread.currentThread().name}")
    delay(1000L)
}

fun Int.hello()
{
    println(this * 5)
}
suspend fun performBackgroundWork() = coroutineScope { // this: CoroutineScope
    // Starts a coroutine that runs without blocking the scope
    this.launch {
        // Suspends to simulate background work
        delay(100.milliseconds)
        println("Sending notification in background")
    }

    // Main coroutine continues while a previous one suspends
    println("Scope continues")
}
