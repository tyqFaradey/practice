package com.example.feature_auth.register

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.core_common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterViewModel @Inject constructor() :
    BaseViewModel<RegisterEvent, RegisterState>(
        initialState = RegisterState()
    ) {

    fun register() {
        viewModelScope.launch {
            updateState { copy(isLoading = true) }
            delay(1000)
            sendEvent(RegisterEvent.AuthSuccess)
        }
    }

    fun onLoginChanged(value: String) {

    }
    fun onPasswordChanged(value: String) {

    }
}