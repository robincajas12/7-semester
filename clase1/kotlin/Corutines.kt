gradle.properties
kotlin.code.style=official
org.gradle.configuration-cache=true // nos ayuda a activar la cache del gradle, mas rapido

dependencies {
  testImplementation(kotlin("test"))
  // Source: https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
  runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}
package com.prograavanzada

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking {
  println("Main program starts: ${Thread.currentThread().name}")
  getProducts()
  getUsers()
  println("Fin")
  launch {
    getProducts()
  }
  launch {
    getUsers()
  }
  val products = async {getProducts()}
  val users = async {getUsers()}
  println(users.await())
  println(users.await())
  /*tareas pesadas*/
  launch(context = Dispatchers.Default) {
    println(Thread.currentThread())
    var suma = 0
    for(i in 1 .. 1000_000_000)
    {
      suma += i
      if(i  > 5 ) {
        this.cancel()
        println("Resultado $suma")

      }
    }
  }.join()
}


/* corutina secuencial*/
suspend fun getProducts()
{
  delay(3*1000)
  println("Productos cargados")
}

suspend fun getUsers(){
  delay(2*1000)
  println("Users cargados")
}
/**------------------------------------*/



