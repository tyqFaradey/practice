package com.example.feature_auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginRoute(
    onSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event -> when(event) {
                is LoginEvent.AuthSuccess -> { onSuccess() }
                is LoginEvent.NavigateToRegister -> { onNavigateToRegister() }
            }
        }
    }

    LoginScreen(
        state = state,
        onLoginChanged = viewModel::onLoginChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onLoginClick = viewModel::onFormSubmit,
        onToRegisterClick = viewModel::onToRegister
    )
}