fun main()
{
    println("UnU")
    val temperatureList= listOf<Int>(12,16,20,18,45,26)
    val handler = TemperaturesHandler()
    temperatureList.forEach { handler.show(it.toString()) }
    temperatureList.map {a->if(handler.isHighTemperature(a) return "alta" else if(handler.isLowTemperature(a)) "alta" else "media")}
}
class TemperaturesHandler()
{

    fun isHighTemperature(temperature: Int): Boolean = temperature > 25

    fun isLowTemperature(temperature: Int): Boolean = temperature <= 10

    fun show(mensaje:String) = println(mensaje)

    fun convertToFarenheit(celsius : Int) : Int = celsius*(9/5)+32


}
