package com.example.feature_auth.navigation

import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.feature_auth.login.LoginRoute
import com.example.feature_auth.register.RegisterRoute

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

inline fun <reified T : Any> NavGraphBuilder.authNavGraph(
    navController: NavController,
    noinline onAuthSuccess: () -> Unit
) {
    navigation<T>(
        startDestination = AuthRoute.Login) {
        composable<AuthRoute.Login> {
            LoginRoute(
                onNavigateToRegister = { navController.navigate(AuthRoute.Register) },
                onSuccess = onAuthSuccess
            )
        }
        composable<AuthRoute.Register> {
            RegisterRoute(
                onNavigateToLogin = { navController.popBackStack() },
                onSuccess = onAuthSuccess
            )
        }
    }
}