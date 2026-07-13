fun interface Monoid<A> {
    fun empty(): A
    fun combine(a: A, b: A): A
}

// Extensión para sumar listas fácilmente
fun <A> List<A>.fold(monoid: Monoid<A>): A =
    this.fold(monoid.empty()) { acc, element -> monoid.combine(acc, element) }

fun main() {
    val numeros = listOf(1, 2, 3, 4)
    val resultado = numeros.fold(IntSumMonoid) // 10
}

// generar una interza que permita trabajar con casos vacios
