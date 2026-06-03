package com.example.feature_deposits.navigation

import androidx.navigation.compose.composable
import androidx.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.feature_deposits.deposits.DepositsScreen


inline fun <reified T : Any> NavGraphBuilder.depositsNavGraph(
    navController: NavController
) {
    navigation<T>(
        startDestination = DepositsRoute.List) {
        composable<DepositsRoute.List> {
            DepositsScreen()
        }
    }
}