package com.example.app.navigation

import kotlinx.serialization.Serializable

internal abstract class RootRoute {
    @Serializable object Auth
    @Serializable object Main
}