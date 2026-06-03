package com.example.feature_calculation.navigation

import kotlinx.serialization.Serializable


abstract class CalculationRoute {
    @Serializable object FirstStep
    @Serializable object SecondStep
    @Serializable object LastStep
}

