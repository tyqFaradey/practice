package ci.nsu.mobile.main.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("log_in")
    object Signin : Screen("Sign_in")
    object Main : Screen("Main")
}