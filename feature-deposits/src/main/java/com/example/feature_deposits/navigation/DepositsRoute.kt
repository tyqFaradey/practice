package com.example.feature_deposits.navigation

import kotlinx.serialization.Serializable


abstract class DepositsRoute {
    @Serializable object FirstStep
    @Serializable object SecondStep
    @Serializable object LastStep
}

