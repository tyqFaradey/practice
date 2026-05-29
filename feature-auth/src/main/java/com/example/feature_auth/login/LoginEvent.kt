package com.example.feature_auth.login

import com.example.core_common.UiEvent

sealed interface LoginEvent: UiEvent {
    data object AuthSuccess  : LoginEvent
    data object NavigateToRegister : LoginEvent
}