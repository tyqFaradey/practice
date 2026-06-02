package com.example.feature_users.users

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UsersRoute(
    viewModel: UsersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    UsersScreen(
        state = state,
        onRefresh = viewModel::onRefresh
    )
}