fun main()
{
    println("UnU")
    val temperatureList= listOf<Int>(12,16,20,18,45,26, 5, 7, 0)
    val handler = TemperaturesHandler()
    temperatureList.forEach { handler.show("temperatura: "+it.toString()) }
    val repartir : (Int) -> String = {v:Int ->
        if(handler.isHighTemperature(v)) "ALTA"
        else if (handler.isLowTemperature(v)) "BAJA"
        else "NORMAL"
    }

    val res = temperatureList.groupBy(repartir)
    res.println()
    ("temperatures converted to Farenheit: " + temperatureList.map { handler.convertToFarenheit(it) }).println()
    "Hola Mundo".println()
    res.map { mapOf<String, Int>(it.key to it.value.reduce { acc, i -> acc + i }) }.println()
    res.mapValues {it.value.sum()}.println()

}

fun Any.println() = println(this)

class TemperaturesHandler()
{

    fun isHighTemperature(temperature: Int): Boolean = temperature > 25

    fun isLowTemperature(temperature: Int): Boolean = temperature <= 10

    fun show(mensaje:String) = println(mensaje)

    fun convertToFarenheit(celsius : Int) : Int = celsius*(9/5)+32


}

fun forRecursivo(i: Int, contador: Int): Int {
    if(i < 0) return contador
    println("Recursivo: "+i)
    return forRecursivo(i-1, contador+ i)
}