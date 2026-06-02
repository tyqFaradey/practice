package com.example.feature_auth.api.schemas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    val login: String,
    val password: String
)