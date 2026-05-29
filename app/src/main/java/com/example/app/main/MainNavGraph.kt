package com.example.app.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
        composable<MainRoute.Users> {
            Text("123")
        }
        composable<MainRoute.Deposits> {
            Text("123456")
        }
        composable<MainRoute.Calculation> {
            Text("123456789")
        }
    }
}