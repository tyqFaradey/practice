package com.example.app.main

import kotlinx.serialization.Serializable


internal abstract class MainRoute {
    @Serializable object Users
    @Serializable object Deposits
    @Serializable object Calculation
}
