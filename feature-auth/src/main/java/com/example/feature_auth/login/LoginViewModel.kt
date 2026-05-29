package com.example.feature_auth.login

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.core_common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor() :

    BaseViewModel<LoginEvent, LoginState>(
        initialState = LoginState()
    ) {

    fun login() {
        viewModelScope.launch {
            updateState { copy(isLoading = true) }
            delay(1000)
            sendEvent(LoginEvent.AuthSuccess)
        }
    }

    fun onLoginChanged(value: String) {

    }
    fun onPasswordChanged(value: String) {

    }
}