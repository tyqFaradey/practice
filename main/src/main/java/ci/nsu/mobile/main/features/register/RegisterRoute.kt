package ci.nsu.mobile.main.features.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ci.nsu.mobile.main.features.login.LoginEvent
import ci.nsu.mobile.main.features.login.LoginScreen
import ci.nsu.mobile.main.features.login.LoginViewModel

@Composable
fun LoginRoute(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is LoginEvent.Navigate -> {
                    navController.navigate(event.route)
                }
            }
        }
    }


    val state by viewModel.state.collectAsState()
    RegisterScreen(
        state = state,
        onButtonClicked = {},
        onLinkClicked = {},
        onUsernameChanged = {},
        onPasswordChanged = {},
    )
}