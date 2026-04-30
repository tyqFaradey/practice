package ci.nsu.mobile.main.features.login

sealed class LoginEvent {
    data class Navigate(val route: String) : LoginEvent()

}