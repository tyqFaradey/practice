package com.example.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.main.MainScreen

import com.example.feature_auth.navigation.authNavGraph

@Composable
fun RootNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RootRoute.Auth
    ) {
        authNavGraph<RootRoute.Auth>(
            navController = navController,
            onAuthSuccess = {
                navController.navigate(RootRoute.Main) {
                    popUpTo<RootRoute.Auth> { inclusive = true }
                }
            }
        )
        composable<RootRoute.Main> {
            MainScreen(
                onLogout = {
                navController.navigate(RootRoute.Auth) {
                    popUpTo<RootRoute.Main> { inclusive = true }
                }
            }
            )
        }
    }
}
