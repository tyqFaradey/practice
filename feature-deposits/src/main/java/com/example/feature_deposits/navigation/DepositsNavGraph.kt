package com.example.feature_deposits.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.feature_calculations.calculation.CalculationViewModel

import com.example.feature_calculations.calculation.result.ResultScreen
import com.example.feature_calculations.calculation.step1.Step1Screen
import com.example.feature_calculations.calculation.step2.Step2Screen


inline fun <reified T : Any> NavGraphBuilder.calculationNavGraph(
    navController: NavController
) {
    navigation<T>(
        startDestination = CalculationRoute.FirstStep) {
        composable<CalculationRoute.FirstStep> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<T>()
            }
            val viewModel: CalculationViewModel = hiltViewModel(parentEntry)

            Step1Screen(
                viewModel = viewModel,
                onNext = { navController.navigate(CalculationRoute.SecondStep) }
            )
        }
        composable<CalculationRoute.SecondStep> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<T>()
            }
            val viewModel: CalculationViewModel = hiltViewModel(parentEntry)

            Step2Screen(
                viewModel = viewModel,
                onNext = { navController.navigate(CalculationRoute.LastStep) },
                onBack = { navController.navigate(CalculationRoute.FirstStep) }
            )

        }
        composable<CalculationRoute.LastStep> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<T>()
            }
            val viewModel: CalculationViewModel = hiltViewModel(parentEntry)

            ResultScreen(
                viewModel = viewModel,
                onBack = { navController.navigate(CalculationRoute.FirstStep) {
                    popUpTo<T> { inclusive = true }
                } }

            )
        }
    }
}