Recursive to TailRecursive no chigai 
```kotlin
fun factorial(n: Int): Long {
    if(n == 1) return 1
    return n * factorial(n-1)
}
tailrec fun factorialTailRec(n : Int, resultado : Long = 1) : Long{
    return if (n == 1) resultado else factorialTailRec(n-1, resultado*n)
}
```

```kotlin
```
