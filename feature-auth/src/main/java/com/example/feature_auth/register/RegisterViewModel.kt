package com.example.feature_auth.register

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.example.core_common.BaseViewModel
import com.example.core_validation.rules.BlankValidator
import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.LoginValidator
import com.example.core_validation.rules.PhoneValidator
import com.example.feature_auth.login.LoginEvent
import com.example.feature_auth.login.LoginForm
import com.example.feature_auth.login.toLoginRequest
import com.example.feature_auth.repository.AuthRepository


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository,

    private val formValidator: RegisterFormValidator,

    private val blankValidator: BlankValidator,
    private val loginValidator: LoginValidator,
    private val emailValidator: EmailValidator,
    private val phoneValidator: PhoneValidator,
    private val passwordValidator: PasswordValidator,
) : BaseViewModel<RegisterEvent, RegisterState>(
        initialState = RegisterState()
    ) {
    fun onFirstNameChanged(value: String) {
        val validation = blankValidator.validate(value)
        updateState {
            copy(
                firstName = value,
                firstNameErrors = validation.errors
            )
        }
    }
    fun onLastNameChanged(value: String) {
        val validation = blankValidator.validate(value)
        updateState {
            copy(
                lastName = value,
                lastNameErrors = validation.errors
            )
        }
    }
    fun onMiddleNameChanged(value: String) {
        val validation = blankValidator.validate(value)
        updateState {
            copy(
                middleName = value,
                middleNameErrors = validation.errors
            )
        }
    }

    fun onLoginChanged(value: String) {
        val validation = loginValidator.validate(value)
        updateState {
            copy(
                login = value,
                loginErrors = validation.errors
            )
        }
    }
    fun onEmailChanged(value: String) {
        val validation = emailValidator.validate(value)
        updateState {
            copy(
                email = value,
                emailErrors = validation.errors
            )
        }
    }
    fun onPhoneChanged(value: String) {
        val validation = phoneValidator.validate(value)
        updateState {
            copy(
                phone = value,
                phoneErrors = validation.errors
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

        val form = RegisterForm(
            firstName = currentState.firstName,
            lastName = currentState.lastName,
            middleName = currentState.middleName,
            login = currentState.login,
            email = currentState.email,
            phone = currentState.phone,
            password = currentState.password,
        )

        val validationResult = formValidator.validate(form)

        updateState {
            copy(
                firstNameErrors = validationResult.firstNameErrors,
                lastNameErrors = validationResult.lastNameErrors,
                middleNameErrors = validationResult.middleNameErrors,
                loginErrors = validationResult.loginErrors,
                emailErrors = validationResult.emailErrors,
                phoneErrors = validationResult.phoneErrors,
                passwordErrors = validationResult.passwordErrors,
            )
        }

        return validationResult.isValid
    }



    fun register() {
        updateState { copy(isLoading = true) }
        viewModelScope.launch {
            val request = state.value.toRegisterRequest()
            repository.register(request)
                .onSuccess {
                    sendEvent(RegisterEvent.AuthSuccess)
                }
                .onFailure {
                        e -> Log.d("LOCAL", e.toString())
                }
        }
        updateState { copy(isLoading = false) }
    }

    fun onFormSubmit() {
        if (!validateAll()) return
        register()
    }

    fun toLogin() {
        viewModelScope.launch {
            sendEvent(RegisterEvent.NavigateToLogin)
        }
    }
}