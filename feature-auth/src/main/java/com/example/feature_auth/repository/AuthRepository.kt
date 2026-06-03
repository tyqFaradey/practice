package com.example.feature_auth.repository

import android.util.Log
import javax.inject.Inject


import com.example.core_session.SessionRepository
import com.example.feature_auth.api.AuthApi
import com.example.feature_auth.api.schemas.AuthResponse
import com.example.feature_auth.api.schemas.LoginRequest
import com.example.feature_auth.api.schemas.RegisterRequest
import kotlin.coroutines.cancellation.CancellationException


class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val sessionRepository: SessionRepository
) {
    suspend fun login(request: LoginRequest): Result<Unit> {
        return runCatching {
            val response = api.login(request)
            sessionRepository.saveToken(response.token)
            val userResponse = api.getUserByLogin(request.login)
            sessionRepository.saveUserId(userResponse.id.toString())
        }.onFailure { exception ->
            if (exception is CancellationException) throw exception
            sessionRepository.clearSession()
        }
    }

    suspend fun register(request: RegisterRequest): Result<Unit> {
        return runCatching {
            val response = api.register(request)
            sessionRepository.saveToken(response.token)
            val userResponse = api.getUserByLogin(request.login)
            sessionRepository.saveUserId(userResponse.id.toString())

        }.onFailure { exception ->
            if (exception is CancellationException) throw exception
            sessionRepository.clearSession()
        }
    }
}