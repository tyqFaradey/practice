package com.example.feature_users.navigation

import androidx.navigation.compose.composable
import androidx.navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

import com.example.feature_users.users.UsersRoute

inline fun <reified T : Any> NavGraphBuilder.usersNavGraph(
    navController: NavController,
) {
    navigation<T>(
        startDestination = UsersRoute.Main) {
        composable<UsersRoute.Main> {
            UsersRoute()
        }
    }
}