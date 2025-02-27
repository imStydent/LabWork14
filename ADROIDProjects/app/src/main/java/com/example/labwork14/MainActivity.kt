package com.example.labwork14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork14.ui.theme.LabWork14Theme
import java.lang.IllegalArgumentException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork14Theme {
                division(4.0,2.0)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    /**
     *  Делит два предаставленных числа
     *
     *  @param [a] Делимое
     *  @param [b] Делитель
     *
     *  @return Возвращает результат деления a/b
     *
     *  @exception IllegalArgumentException если делитель равен 0.0
     */
    fun division(a: Double, b: Double) : Double{
        if (b == 0.0) throw IllegalArgumentException("На ноль делить нельзя!")
        return a/b
    }
}

/**
 * Класс, предаставляющий логин и пароль пользователя
 *
 * @property [login] Логин пользователя
 * @property [password] Пароль пользователя
 */
data class User(val login: String, val password: String){
    /**
     * Проверяет, совпадает ли введенный пароль с паролем пользователя
     *
     * @param [inputPassword] Пароль для проверки
     * @return true, если пароли совпадают, иначе false
     */
    fun isPasswordCorrect(inputPassword: String) : Boolean{
        return password == inputPassword
    }
}
/**
 * Выводит на экран "Hello {пользовательский текст}" с заданым Modifier
 *
 * @param [name] то, что будет писаться после "Hello"
 * @param [modifier] modifier, который будет применен к тексту
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork14Theme {
        Greeting("Android")
    }
}