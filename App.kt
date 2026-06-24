package com.myapp.login

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import ui.screens.LoginScreen
import ui.screens.RegisterScreen // Импортируем новый экран
import ui.theme.*

sealed class Screen {
    object Login : Screen()
    object Dashboard : Screen()
    object Register : Screen()
}

@Preview
@Composable
fun App() {
    AppTheme {
        var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

        when (currentScreen) {
            is Screen.Login -> {
                LoginScreen(
                    onLoginSuccess = { currentScreen = Screen.Dashboard },
                    onRegisterClick = { currentScreen = Screen.Register }
                )
            }
            is Screen.Dashboard -> {
                // Здесь можно будет потом создать отдельный DashboardScreen
                Text("Добро пожаловать в личный кабинет!")
            }
            is Screen.Register -> {
                // ВЫЗЫВАЕМ ЭКРАН РЕГИСТРАЦИИ ВМЕСТО ТЕКСТА
                RegisterScreen(
                    onRegisterSuccess = {
                        // После успешной регистрации возвращаем на вход или сразу в кабинет
                        currentScreen = Screen.Login
                    },
                    onBackToLogin = {
                        currentScreen = Screen.Login
                    }
                )
            }
        }
    }
}