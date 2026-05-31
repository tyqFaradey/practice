package com.example.feature_auth.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.core_common.BaseViewModel
import com.example.core_validation.rules.BlankValidator
import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.LoginValidator
import com.example.core_validation.rules.PhoneValidator
import com.example.feature_auth.register.RegisterForm
import com.example.feature_auth.register.RegisterFormValidator
import com.example.feature_auth.register.RegisterState
import com.example.feature_auth.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,

    private val formValidator: LoginFormValidator,

    private val loginValidator: LoginValidator,
    private val passwordValidator: PasswordValidator,
) : BaseViewModel<LoginEvent, LoginState>(
        initialState = LoginState()
    ) {

    fun onLoginChanged(value: String) {
        val validation = loginValidator.validate(value)
        updateState {
            copy(
                login = value,
                loginErrors = validation.errors
            )
        }
    }
    fun onPasswordChanged(value: String) {
        val validation = passwordValidator.validate(value)
        updateState {
            copy(
                password = value,
                passwordErrors = validation.errors
            )
        }
    }

    fun validateAll(): Boolean {
        val currentState = state.value

        val form = LoginForm(
            login = currentState.login,
            password = currentState.password,
        )

        val validationResult = formValidator.validate(form)

        updateState {
            copy(
                loginErrors = validationResult.loginErrors,
                passwordErrors = validationResult.passwordErrors,
            )
        }

        return validationResult.isValid
    }

    fun login() {
        updateState { copy(isLoading = true) }
        viewModelScope.launch {
            val request = state.value.toLoginRequest()
            repository.login(request)
                .onSuccess {
                    sendEvent(LoginEvent.AuthSuccess)
                }
                .onFailure {
                    e -> Log.d("LOCAL", e.toString())
                }
        }
        updateState { copy(isLoading = false) }
    }

    fun onFormSubmit() {
        if (!validateAll()) return
        login()
    }

    fun onToRegister() {
        viewModelScope.launch {
            sendEvent(LoginEvent.NavigateToRegister)
        }
    }

}