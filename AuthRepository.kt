package data

data class LoginResult(
    val isSuccess: Boolean,
    val errorText: String? = null
)

object AuthRepository {
    private const val VALID_EMAIL = "test@test.com"
    private const val VALID_PASSWORD = "1234"

    fun login(email: String, password: String): LoginResult {
        if (!isVaildEmail(email)) {
            return LoginResult(
                false,
                "Введите коррекнтный email адрес")
        }

        if (password.isBlank()) {
        return LoginResult(
            false,
            errorText = "Введите пароль"
        )
        }
        return if (email == VALID_EMAIL && password == VALID_PASSWORD) {
            LoginResult(isSuccess = true)
        } else {
            LoginResult(
                false,
                errorText = "Неверный email или пароль"
            )
        }
    }

    private fun isVaildEmail(email: String): Boolean {
        val emailRegex = Regex("")
        return emailRegex.matches(email.trim())
    }
}