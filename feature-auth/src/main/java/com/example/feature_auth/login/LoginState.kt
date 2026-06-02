package com.example.feature_auth.login

import android.telephony.mbms.MbmsErrors
import com.example.core_common.UiState
import com.example.feature_auth.api.schemas.LoginRequest

data class LoginState(
    val login: String = "",
    val password: String = "",

    val loginErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),

    val isLoading: Boolean = false
) : UiState

fun LoginState.toLoginRequest(): LoginRequest {
    return LoginRequest(
        login = login,
        password = password,
    )
}