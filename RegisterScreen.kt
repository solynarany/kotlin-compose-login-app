package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ui.theme.*

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onBackToLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Переменная для отслеживания ошибки
    var isEmailError by remember { mutableStateOf(false) }

    // Простая функция проверки email
    fun checkEmail(text: String): Boolean {
        return text.contains("@") && text.contains(".")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundPink
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Регистрация",
                style = AppTypography.screenTitle
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it.trim() // Убираем пробелы автоматически
                    isEmailError = false // Сбрасываем ошибку при печати
                },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                isError = isEmailError, // Если true — поле станет красным
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                supportingText = {
                    if (isEmailError) {
                        Text("Введите корректный email (например, name@mail.com)")
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = SurfaceWhite,
                    unfocusedContainerColor = SurfaceWhite,
                    focusedBorderColor = PrimaryPink,
                    focusedLabelColor = PrimaryPink,
                    errorContainerColor = SurfaceWhite // Чтобы поле не становилось серым при ошибке
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Пароль") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = SurfaceWhite,
                    unfocusedContainerColor = SurfaceWhite,
                    focusedBorderColor = PrimaryPink,
                    focusedLabelColor = PrimaryPink
                )
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Повторите пароль") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = SurfaceWhite,
                    unfocusedContainerColor = SurfaceWhite,
                    focusedBorderColor = PrimaryPink,
                    focusedLabelColor = PrimaryPink
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (!checkEmail(email)) {
                        isEmailError = true // Включаем ошибку, если email плохой
                    } else if (password == confirmPassword && email.isNotEmpty()) {
                        onRegisterSuccess()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryPink,
                    contentColor = TextOnPrimary
                )
            ) {
                Text("Зарегистрироваться", style = AppTypography.buttonLabel)
            }

            TextButton(onClick = onBackToLogin) {
                Text(
                    "Уже есть аккаунт? Войти",
                    style = AppTypography.linkText
                )
            }
        }
    }
}