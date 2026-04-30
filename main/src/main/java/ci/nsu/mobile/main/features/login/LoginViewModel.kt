package ci.nsu.mobile.main.features.login

import javax.inject.Inject
import retrofit2.HttpException
import kotlinx.serialization.SerializationException
import java.io.IOException


import android.util.Log


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ci.nsu.mobile.main.core.navigation.Screen

import ci.nsu.mobile.main.data.local.storage.TokenManager
import ci.nsu.mobile.main.data.repository.AuthRepository
import ci.nsu.mobile.main.data.repository.GroupRepository
import ci.nsu.mobile.main.model.dto.LoginRequest

import ci.nsu.mobile.main.data.repository.UserRepository
import kotlinx.coroutines.flow.update


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
): ViewModel() {
    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun login(username: String, password: String) {
        val request = LoginRequest(username, password)
        viewModelScope.launch {
            repository.login(request)
                .onSuccess { response ->
                    _event.emit(LoginEvent.Navigate(Screen.Main.route))
                }
                .onFailure { e -> Log.d("1234", e.toString())}
        }
    }

    private fun usernameValidate(username: String) : List<String> {
        val errors = mutableListOf<String>()

        if (username.isBlank()) errors.add("Логин обязателен")
        if (username.length < 3) errors.add("Минимум 3 символа")

        return errors
    }
    fun onUsernameChanged(value: String) {
        val errors = usernameValidate(value)

        _state.update {
            it.copy(
                username = value,
                usernameErrors = errors,
                isButtonEnabled = isAllValid()
            )
        }
    }
    private fun passwordValidate(password: String): List<String> {
        val errors = mutableListOf<String>()

        if (password.isBlank()) errors.add("Пароль обязателен")
        if (password.length < 8) errors.add("Минимум 8 символов")
        if (!password.any { it.isUpperCase() }) errors.add("Нет заглавной буквы")
        if (!password.any { it.isLowerCase() }) errors.add("Нет строчной буквы")
        if (!password.any { it.isDigit() }) errors.add("Нет цифры")

        return errors
    }
    fun onPasswordChanged(value: String) {
        val errors = passwordValidate(value)

        _state.update {
            it.copy(
                password = value,
                passwordErrors = errors,
                isButtonEnabled = isAllValid()
            )
        }
    }
    fun isAllValid(): Boolean {
        val currentState = _state.value
        return currentState.usernameErrors.isEmpty() &&
                currentState.passwordErrors.isEmpty()
    }
    fun onLogin() {
        val currentState = _state.value
        _state.update { it.copy(isLoading = true, isButtonEnabled = false) }
        login(currentState.username, currentState.password)
        _state.update { it.copy(isLoading = false, isButtonEnabled = true) }
    }
}