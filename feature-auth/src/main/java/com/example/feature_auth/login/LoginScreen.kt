package com.example.feature_auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Column {
        TextField(
            value = state.login,
            onValueChange = onLoginChanged
        )

        TextField(
            value = state.password,
            onValueChange = onPasswordChanged
        )

        Button(
            onClick = onLoginClick
        ) {
            Text("Login")
        }
    }
}