package com.example.main.navigation

import kotlinx.serialization.Serializable

@Serializable object MainGraph

internal abstract class MainRoute {
    @Serializable object Users
    @Serializable object Deposits
    @Serializable object Calculation
}

