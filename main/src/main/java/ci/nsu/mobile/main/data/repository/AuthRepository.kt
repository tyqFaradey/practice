package ci.nsu.mobile.main.data.repository

import android.util.Log
import javax.inject.Inject

import ci.nsu.mobile.main.core.network.api.ApiClient
import ci.nsu.mobile.main.data.local.storage.TokenManager



import ci.nsu.mobile.main.model.dto.AuthResponse
import ci.nsu.mobile.main.model.dto.LoginRequest
import ci.nsu.mobile.main.model.dto.RegisterRequest


class AuthRepository @Inject constructor(
    private val api: ApiClient,
    private val tokenManager: TokenManager
) {
    suspend fun login(request: LoginRequest): Result<AuthResponse> {
        return runCatching {
            val response = api.login(request)

            tokenManager.saveToken(response.token)

            response
        }

    }

    fun isLoggedIn(): Boolean {
        return tokenManager.getToken() != null
    }

    fun logout() {
        tokenManager.clearToken()
    }
}