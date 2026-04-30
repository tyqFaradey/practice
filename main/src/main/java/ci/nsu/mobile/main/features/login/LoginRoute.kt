package ci.nsu.mobile.main.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun LoginRoute(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
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
    LoginScreen(
        state = state,
        onButtonClicked = viewModel::onLogin,
        onLinkClicked = {  },
        onUsernameChanged = viewModel::onUsernameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
    )
}