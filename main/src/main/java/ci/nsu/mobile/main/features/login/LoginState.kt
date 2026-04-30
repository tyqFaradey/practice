package ci.nsu.mobile.main.features.login

import ci.nsu.mobile.main.core.utils.Field

data class LoginState(
    val isLoading: Boolean = false,
    val isButtonEnabled: Boolean = false,

    val error: String? = null,

    val fields: Map<Field, String> = mapOf(
        Field.USERNAME to "",
        Field.PASSWORD to ""
    ),
    val errors: Map<Field, List<String>> = Field.entries.associateWith { emptyList() },
)