package com.example.feature_auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core_ui.BaseScreen
import com.example.core_ui.ButtonsPanel
import com.example.core_ui.Link
import com.example.core_ui.PADDING
import com.example.core_ui.TextField

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClick: () -> Unit,
    onToRegisterClick: () -> Unit
) {
    BaseScreen(
        title = "Вход",
        bottomBar = {
            Column(
                modifier = Modifier
                    .imePadding()
                    .padding(PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(PADDING)
            ) {
                ButtonsPanel {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onLoginClick
                    ) {
                        Text("Войти")
                    }
                }
                Link(
                    text = "Регистрация",
                    onClicked = onToRegisterClick
                )

            }
        }
    ) {
        TextField(
            label = "Логин",
            value = state.login,
            errors = state.loginErrors,
            onValueChange = onLoginChanged
        )
        TextField(
            label = "пароль",
            value = state.password,
            errors = state.passwordErrors,
            onValueChange = onPasswordChanged
        )
    }
}