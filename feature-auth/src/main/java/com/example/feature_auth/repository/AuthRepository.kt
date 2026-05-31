package com.example.feature_auth.repository

import android.util.Log
import javax.inject.Inject


import com.example.core_network.auth.TokenManager
import com.example.feature_auth.api.AuthApi
import com.example.feature_auth.api.schemas.AuthResponse
import com.example.feature_auth.api.schemas.LoginRequest
import com.example.feature_auth.api.schemas.RegisterRequest


class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager
) {
    suspend fun login(request: LoginRequest): Result<AuthResponse> {
        return runCatching {
            val response = api.login(request)

            tokenManager.saveToken(response.token)

            response
        }
    }

    suspend fun register(request: RegisterRequest): Result<AuthResponse> {
        return runCatching {
            val response = api.register(request)

            tokenManager.saveToken(response.token)

            response
        }
    }

    fun isLoggedIn(): Boolean {
        return !tokenManager.getToken().isNullOrBlank()
    }

    fun logout() {
        tokenManager.clearToken()
    }
}