package com.example.feature_auth.login

import com.example.core_common.UiState

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false
) : UiState