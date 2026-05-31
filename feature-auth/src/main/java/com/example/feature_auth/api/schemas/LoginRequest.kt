package com.example.feature_auth.api.schemas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    @SerialName("login") val username: String,
    @SerialName("password") val password: String
)