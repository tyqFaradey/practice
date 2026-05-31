package com.example.feature_auth.register

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.example.core_common.BaseViewModel
import com.example.core_validation.rules.BlankValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.LoginValidator
import com.example.feature_auth.repository.AuthRepository


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val blankValidator: BlankValidator,
    private val loginValidator: LoginValidator,
    private val passwordValidator: PasswordValidator,
) : BaseViewModel<RegisterEvent, RegisterState>(
        initialState = RegisterState()
    ) {
    fun onLoginChanged(value: String) {

    }
    fun onPasswordChanged(value: String) {

    }

    fun onFormSubmit() {

    }

    fun register() {
        viewModelScope.launch {
            updateState { copy(isLoading = true) }
            delay(1000)
            sendEvent(RegisterEvent.AuthSuccess)
        }
    }
}