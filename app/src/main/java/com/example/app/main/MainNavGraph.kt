package com.example.app.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.navigation.RootRoute
import com.example.feature_auth.navigation.authNavGraph
import com.example.feature_users.navigation.usersNavGraph

@Composable
fun MainNavGraph(
    navController: NavHostController,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = MainRoute.Users,
        modifier = modifier
    ) {
        usersNavGraph<MainRoute.Users>(
            navController = navController,
        )
        composable<MainRoute.Deposits> {
            Text("123456")
        }
        composable<MainRoute.Calculation> {
            Text("123456789")
        }
    }
}