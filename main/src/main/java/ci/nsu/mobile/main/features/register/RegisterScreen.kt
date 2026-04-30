package ci.nsu.mobile.main.features.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import ci.nsu.mobile.main.core.ui.BaseScreen
import ci.nsu.mobile.main.core.ui.ButtonsPanel
import ci.nsu.mobile.main.core.ui.ErrorsCard
import ci.nsu.mobile.main.features.login.LoginState
import ci.nsu.mobile.main.features.login.PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
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
                        Text("Зарегистрироваться")
                    }
                }
                Text(
                    text = "Вход",
                    color = Color.LightGray,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { onLinkClicked() }
                )
            }
        }
    ) {

    }
}