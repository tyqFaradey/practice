package ci.nsu.mobile.main.features.login

import androidx.compose.runtime.Composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

import ci.nsu.mobile.main.core.ui.BaseScreen
import ci.nsu.mobile.main.core.ui.ButtonsPanel
import ci.nsu.mobile.main.core.ui.ErrorsCard


val PADDING = 12.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginState,
    onButtonClicked: () -> Unit,
    onLinkClicked: () -> Unit,
    onUsernameChanged: (value: String) -> Unit,
    onPasswordChanged: (value: String) -> Unit,
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
                        enabled = state.isButtonEnabled,
                        onClick = { onButtonClicked() }
                    ) {
                        Text("Войти")
                    }
                }
                Text(
                    text = "Регистрация",
                    color = Color.LightGray,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { onLinkClicked() }
                )
            }
        }
    ) {
        OutlinedTextField(
            label = { Text("Логин") },
            value = state.username,

            onValueChange = onUsernameChanged,
            isError = state.usernameErrors.isNotEmpty(),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = PADDING, end = PADDING),
            singleLine = true,
        )
        if (state.usernameErrors.isNotEmpty()) {
            ErrorsCard(state.usernameErrors)
        }

        OutlinedTextField(
            label = { Text("Пароль") },
            value = state.password,

            onValueChange = onPasswordChanged,
            isError = state.passwordErrors.isNotEmpty(),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = PADDING, end = PADDING),
            singleLine = true,
        )
        if (state.passwordErrors.isNotEmpty()) {
            ErrorsCard(state.passwordErrors)
        }
    }
}