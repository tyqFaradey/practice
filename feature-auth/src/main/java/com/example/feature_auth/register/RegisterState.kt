package com.example.feature_auth.register

import com.example.core_common.UiState

data class RegisterState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false
) : UiState