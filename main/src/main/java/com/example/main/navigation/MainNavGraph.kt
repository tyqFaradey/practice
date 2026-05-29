package com.example.main.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation<MainGraph>(startDestination = MainRoute.Users) {
        composable<MainRoute.Users> {
            Text("1")
        }
        composable<MainRoute.Deposits> {
            Text("2")
        }
        composable<MainRoute.Calculation> {
            Text("3")
        }
    }
}