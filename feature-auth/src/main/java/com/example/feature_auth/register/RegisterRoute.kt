package com.example.feature_auth.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegisterRoute(
    onSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    val viewModel: RegisterViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event -> when(event) {
                is RegisterEvent.AuthSuccess -> { onSuccess() }
                is RegisterEvent.NavigateToLogin -> { onNavigateToLogin() }
            }
        }
    }

    LoginScreen(
        state = state,
        onLoginChanged = viewModel::onLoginChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onLoginClick = viewModel::register
    )
}