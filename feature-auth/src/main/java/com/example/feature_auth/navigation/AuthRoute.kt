package com.example.feature_auth.navigation

import kotlinx.serialization.Serializable


abstract class AuthRoute {
    @Serializable object Login
    @Serializable object Register
}

