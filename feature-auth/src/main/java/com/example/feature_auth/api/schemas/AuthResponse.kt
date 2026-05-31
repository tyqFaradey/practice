package com.example.feature_auth.api.schemas

import kotlinx.serialization.Serializable
@Serializable
data class AuthResponse(
    val token: String
)