package ci.nsu.mobile.main.features.login

import javax.inject.Inject

import android.util.Log

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import ci.nsu.mobile.main.core.navigation.Screen
import ci.nsu.mobile.main.core.utils.Field
import ci.nsu.mobile.main.core.utils.Validator
import ci.nsu.mobile.main.data.repository.AuthRepository
import ci.nsu.mobile.main.model.dto.LoginRequest


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
): ViewModel() {
    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()


    fun validateField(field: Field, value: String): List<String> {
        return Validator.validators[field]?.invoke(value) ?: emptyList()
    }
    fun validateAll() {
        _state.update { current ->
            val newErrors = current.fields.mapValues { (field, value) ->
                validateField(field, value)
            }
            current.copy(
                errors = newErrors,
                isButtonEnabled = newErrors.values.all { it.isEmpty() }
            )
        }
    }
    fun onFieldChange(field: Field, value: String) {
        _state.update {
            val errors = validateField(field, value)
            val newFields = it.fields + (field to value)
            val newErrors = it.errors + (field to errors)

            it.copy(
                fields = newFields,
                errors = newErrors,
                isButtonEnabled = newErrors.values.all { item -> item.isEmpty() }
            )
        }
    }

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

    fun onLogin() {
        validateAll()
        val currentState = _state.value
        if (!currentState.isButtonEnabled) return
        _state.update { it.copy(isLoading = true, isButtonEnabled = false) }
        login(currentState.fields[Field.USERNAME]!!, currentState.fields[Field.PASSWORD]!!)
        _state.update { it.copy(isLoading = false, isButtonEnabled = true) }
    }

    fun onToRegister() {
        validateAll()
        val currentState = _state.value
        if (!currentState.isButtonEnabled) return
        _state.update { it.copy(isLoading = true, isButtonEnabled = false) }
        login(currentState.fields[Field.USERNAME]!!, currentState.fields[Field.PASSWORD]!!)

    }
}

//private fun usernameValidate(username: String) : List<String> {
//    val errors = mutableListOf<String>()
//
//    if (username.isBlank()) errors.add("Логин обязателен")
//    if (username.length < 3) errors.add("Минимум 3 символа")
//
//    return errors
//}
//fun onUsernameChanged(value: String) {
//    val errors = usernameValidate(value)
//
//    _state.update {
//        it.copy(
//            username = value,
//            usernameErrors = errors,
//            isButtonEnabled = isAllValid()
//        )
//    }
//}
//    private fun passwordValidate(password: String): List<String> {
//        val errors = mutableListOf<String>()
//
//        if (password.isBlank()) errors.add("Пароль обязателен")
//        if (password.length < 8) errors.add("Минимум 8 символов")
//        if (!password.any { it.isUpperCase() }) errors.add("Нет заглавной буквы")
//        if (!password.any { it.isLowerCase() }) errors.add("Нет строчной буквы")
//        if (!password.any { it.isDigit() }) errors.add("Нет цифры")
//
//        return errors
//    }
//    fun onPasswordChanged(value: String) {
//        val errors = passwordValidate(value)
//
//        _state.update {
//            it.copy(
//                password = value,
//                passwordErrors = errors,
//                isButtonEnabled = isAllValid()
//            )
//        }
//    }
//    fun isAllValid(): Boolean {
//        val currentState = _state.value
//        return currentState.usernameErrors.isEmpty() &&
//                currentState.passwordErrors.isEmpty()
//    }