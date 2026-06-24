# シーケンス (Sequence)

1. `var n = 1` という変数を宣言します。
2. `while` の「`()`」の中に `true` を書くと無限ループになります。
3. `while` の中で `yield` を呼び出し、その中に `n` を渡してください。
4. 次の行に `n++` を書きます。

```kotlin
fun numerosAscendentes(): Sequence<Int> = sequence {
    var n = 1
    while (true) {
        yield(n)
        n++
    }
}
```
メイン関数にこれを書いてください：

$n = 10$のとき、1, 2, 3..., 10 のリストを返します

```
fun main()
{
  println(numerosAscendentes().take(10).toList())
}
```

次の例は、無限に掛け算ができる関数です
```kotlin
fun tablaMultiplcarInfinita(): Sequence<Int> = sequence {
  var n = 1
  while (true)
  {
    yield(n*3)
    n++
  }
}
```
これを使えば、リストの最大値を見つけることができます。
 ```kotlin
fun getMax(list: List<Int>, max : Int): Int{
  if(list.size == 0) return max
  if(list.get(0) > max) return getMax(list.drop(1), list.get(0))
  else return getMax(list.drop(1), max)
}
```



