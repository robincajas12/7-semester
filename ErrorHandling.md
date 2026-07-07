

```koltin
import arrow.core.Either
import arrow.core.left
import arrow.core.right

```
```kotlin
package org.example

data class Usuario(
    val correo: String,
    val password: String
)
val listaUsuarios = listOf(
    Usuario("juan@gmail.com", "pass123"),
    Usuario("ana@outlook.com", "secure456"),
    Usuario("pedro@yahoo.com", "qwerty789")
)

fun encontrarUsuario(correo: String): Usuario? {
    return listaUsuarios.find { it.correo == correo }
}
fun encontrarUsuarioConPassword(correo: String, password: String): Result<Usuario> {
    val usuario = listaUsuarios.find { it.correo == correo }

    return when {
        usuario == null -> {
            Result.failure(Exception("Error: El usuario con correo $correo no existe."))
        }
        usuario.password != password -> {
            Result.failure(Exception("Error: Contraseña incorrecta para el usuario $correo."))
        }
        else -> {
            Result.success(usuario)
        }
    }
}
sealed class LoginResultado{
    data class Success(val usuario: Usuario) : LoginResultado()
    data class Failure(val exception: Exception) : LoginResultado()
    data class UsuarioNoEncontrado(val correo: String) : LoginResultado()

}
fun autenticarUsuario(correo: String, password: String): LoginResultado {
    val usuario = listaUsuarios.find { it.correo == correo }

    return when {
        usuario == null -> LoginResultado.UsuarioNoEncontrado(correo)
        usuario.password != password -> LoginResultado.Failure(Exception(""))
        else -> LoginResultado.Success(usuario)
    }
}

fun main() {
    val usuario = encontrarUsuario("juan@gmail.com")

    if (usuario != null) {
        println("Usuario encontrado: ${usuario.correo}")
    } else {
        println("Usuario no encontrado.")
    }
    encontrarUsuarioConPassword("juan", "pass123").onSuccess { println("Usuario encontrado: ${it.correo}") }
        .onFailure { println("Error: ${it.message}") }

    val resultado = autenticarUsuario("juan@gmail.com", "pass123")

    when (resultado) {
        is LoginResultado.Success -> {
            println("Acceso concedido para: ${resultado.usuario.correo}")
        }
        is LoginResultado.Failure -> {
            println("Error de autenticación: ${resultado.exception}")
        }
        is LoginResultado.UsuarioNoEncontrado -> {
            println("El usuario con correo ${resultado.correo} no está registrado.")
        }
    }
}

package org.example

sealed class ErrorLogin {
    object UsuarioNoExiste: ErrorLogin()
    object PasswordInvalid: ErrorLogin()
    object BlockedAccountInvalid: ErrorLogin()
}
```

```koltin
import arrow.core.Either
import arrow.core.left
import arrow.core.right

data class Usuario(
    val correo: String,
    val password: String
)

sealed class ErrorLogin {
    object UsuarioNoExiste : ErrorLogin()
    object PasswordInvalid : ErrorLogin()
    object BlockedAccountInvalid : ErrorLogin()
}

// Retorna Either<ErrorLogin, Usuario>
fun loginArrow(user: Usuario): Either<ErrorLogin, Usuario> {
    return when {
        user.correo == "bloqueado@ejemplo.com" -> 
            ErrorLogin.BlockedAccountInvalid.left()
            
        user.correo != "admin@ejemplo.com" -> 
            ErrorLogin.UsuarioNoExiste.left()
            
        user.password != "1234" -> 
            ErrorLogin.PasswordInvalid.left()
            
        else -> 
            user.right()
    }
}
```
