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

    RegisterScreen(
        state = state,
        onFirstNameChanged = viewModel::onFirstNameChanged,
        onLastNameChanged = viewModel::onLastNameChanged,
        onMiddleNameChanged = viewModel::onMiddleNameChanged,
        onLoginChanged = viewModel::onLoginChanged,
        onEmailChanged = viewModel::onEmailChanged,
        onPhoneChanged = viewModel::onPhoneChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onRegisterClick = viewModel::onFormSubmit,
        onToLogin = viewModel::toLogin
    )
}