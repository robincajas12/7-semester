import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

data class Estudiante(
    val id: Int,
    val nombre: String,
    val nota: Double
)
class SistemasEstudiante
{

    suspend fun getStudents(): List<Estudiante>
    {
        delay(2.seconds)

        return listOf(
            Estudiante(1, "Ana", 9.5),
            Estudiante(2, "Luis", 7.2),
            Estudiante(3, "María", 8.8),
            Estudiante(4, "Carlos", 6.5),
            Estudiante(5, "Sofía", 9.1)
        )
    }
    fun corutine() = runBlocking {
        val students = async { getStudents() }
        students.await()
    }
    fun emitirEstudents(estudiantes: List<Estudiante>) : Flow<Estudiante> = flow<Estudiante>
    {
        delay(1.seconds)
        for (estudiant in estudiantes)
        {
            delay(2.seconds)
            emit(estudiant)
        }
    }
    fun procesarEstudiantes(estudiantes: List<Estudiante>, lambda: (Estudiante)-> Unit){
        estudiantes.forEach(lambda)
    }
}

fun main() = runBlocking {
    try {
        val sistema = SistemasEstudiante()
        println("Loading students.........\n")
        val estudiantes = async { sistema.getStudents() }.await()
        sistema.procesarEstudiantes(estudiantes)
        {
            println("${it.nombre} - ${it.nota}")
        }
        estudiantes.map { it.nombre.uppercase() }.forEach { println(it) }
    }catch (e: Exception)
    {
        e.printStackTrace()
    }
}
