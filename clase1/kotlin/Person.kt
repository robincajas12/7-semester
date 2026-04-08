package org.example

class Person(val name: String, val age: Int, val emails: List<String>) {
    fun login()
    {
        println("Name: $name, Age: $age")
        emails.stream().forEach { email -> println(email) }

    }
    suspend fun xd()
    {
        println("Name: $name, Age: $age")
    }
}