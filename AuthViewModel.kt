// sharedUI/src/commonMain/kotlin/ui/auth/AuthViewModel.kt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun onEmailChange(newValue: String) { _email.value = newValue }
    fun onPasswordChange(newValue: String) { _password.value = newValue }

    fun login() {
        if (email.value.isNotEmpty() && password.value.length >= 6) {
            // Здесь будет вызов API
            _isLoggedIn.value = true
            println("Успешный вход: ${email.value}")
        }
    }
}