import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
// ИСПРАВЛЕНО: Импортируем App из пакета, который указан в самом файле App.kt
import com.myapp.login.App

fun main() = application {
    Window(
        title = "Вход в систему",
        state = rememberWindowState(width = 520.dp, height = 740.dp),
        onCloseRequest = ::exitApplication,
    ) {
        // Установка минимального размера окна
        window.minimumSize = Dimension(350, 600)

        // Теперь вызывается корректная функция из пакета com.myapp.login
        App()
    }
}