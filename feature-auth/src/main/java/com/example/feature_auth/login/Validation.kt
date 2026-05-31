package com.example.feature_auth.login

import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.LoginValidator
import com.example.core_validation.rules.PasswordValidator
import javax.inject.Inject

data class LoginForm (
    val login: String,
    val password: String,
)

data class LoginFormValidationResult(
    val isValid: Boolean,
    val loginErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),
)

class LoginFormValidator @Inject constructor(
    private val loginValidator: LoginValidator,
    private val passwordValidator: PasswordValidator,
) {
    fun validate(form: LoginForm): LoginFormValidationResult {
        val loginRes = loginValidator.validate(form.login)
        val passwordRes = passwordValidator.validate(form.password)

        val isFormValid = loginRes.isValid && passwordRes.isValid

        return LoginFormValidationResult(
            isValid = isFormValid,
            loginErrors = loginRes.errors,
            passwordErrors = passwordRes.errors,
        )
    }
}

