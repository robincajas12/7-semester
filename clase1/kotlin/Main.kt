package org.example
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() {
val x = 2

when (x) {
    1 -> println("Uno")
    2 -> println("Dos")
    3 -> println("Tres")
    else -> println("Otro")
}
for (i in 1..5) {
    println(i)
}
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
    aaa()
    "xdsdaqda".slice(2..6)
    "xdsdaqda".substring(2,5)
    val xd: String = readln();
    if(true and false or !false) println(xd)



}
suspend fun aaa() = coroutineScope{
    this.launch {
        // Suspends to simulate background work
        delay(100.milliseconds)
        println("Sending notification in background")
    }


    // Main coroutine continues while a previous one suspends
    println("Scope continues")
}
suspend fun greet() {
    println("The greet() on the thread: ${Thread.currentThread().name}")
    delay(1000L)
}

fun Int.hello()
{
    println(this * 5)
}


import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main2() {
    val xd = xd();
    println(xd?.let { "Hello, there's data here" });
    println("Hello, world!!!" + a("a"){
        println("#")
    }.b())
    if(5 == 5) println(45)

    val xd1 = when(4){
        5 -> "lol"
        else -> "7w7"
    }
    println(xd1)
    print(a("a"){
        println("#789456")
    }.apply{
        b();
    })

    for(i in 8 downTo 1)
    {
        println(i)
    }

    for (i in 8 downTo 2 step 2){
        println(i)
    }

    alsoFunction()

    val a : Array<String> = arrayOf("a", "b", "c");

    val objetoA = a("a"){
        println("#789456")
    }

    with(objetoA){
        println(this)
        b()
    }

    xd(5){
        println(this)
        println("dentro de a")
    }
    val arr = Array(5, {i -> (i * i).toString()})
    val arr2 = Array(5, {it})
    println(nextInt(1,50))
    println(arr.joinToString())
    println(arr2.joinToString())

    for(i in arr.indices)
    {
        println(arr[i])
    }

    for(i in arr.indices)
    {
        arr[i] = readLine()!!.toInt().also{println("numero:" + it + "ingresado" ) }.toString()
    }
    println(arr.joinToString())
}


fun xd(xdss: Int, ext : a.()-> Unit) :String
{
    println(xdss)
    println(a("unu", {print("unu")}).ext())
    return "xd"
}
fun xd() : String? {
    return "5645646";
}
data class a(val ax : String,val lamda : ()-> Unit)
{
    fun b()
    {
        lamda()
    }
}

fun alsoFunction() {
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .also { println(it) }
            // [GOLD, SILVER, BRONZE]
            .filter { it.length > 4 }
            .also { println(it) }
            // [SILVER, BRONZE]
            .reversed()
    println(reversedLongUppercaseMedals)
    // [BRONZE, SILVER]
}


fun main14052026(){
    val matrix = Array(10, {Array(10, {0})})
     println("Hello Kotlin")
    val matrix1 = Array(3) { DoubleArray(3) }
    val matriz2 = arrayOf(arrayOf(1,2,3), arrayOf(3,4,5))
    val matriz3 = Array(5){4}
    matriz2.forEach { it.forEach { print("$it " +    Random.nextInt(1,10)) } }
    Random.nextInt(1,50);
    print(matriz3.contentToString())
    
}
