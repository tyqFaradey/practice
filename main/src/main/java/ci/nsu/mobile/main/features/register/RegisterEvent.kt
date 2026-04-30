package ci.nsu.mobile.main.features.register

sealed class RegisterEvent {
    data class Navigate(val route: String) : RegisterEvent()
}