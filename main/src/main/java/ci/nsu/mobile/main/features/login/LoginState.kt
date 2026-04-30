package ci.nsu.mobile.main.features.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isButtonEnabled: Boolean = false,

    val error: String? = null,
    val usernameErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),


)