package com.example.feature_auth.register

import com.example.core_validation.rules.BlankValidator
import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.LoginValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.PhoneValidator
import javax.inject.Inject

data class RegisterForm (
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val birthDate: String = "",

    val login: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
)

data class RegisterFormValidationResult(
    val isValid: Boolean,
    val firstNameErrors: List<String> = emptyList(),
    val lastNameErrors: List<String> = emptyList(),
    val middleNameErrors: List<String> = emptyList(),
    val birthDateErrors: List<String> = emptyList(),

    val loginErrors: List<String> = emptyList(),
    val emailErrors: List<String> = emptyList(),
    val phoneErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),
)

class RegisterFormValidator @Inject constructor(
    private val blankValidator: BlankValidator,

    private val loginValidator: LoginValidator,
    private val emailValidator: EmailValidator,
    private val phoneValidator: PhoneValidator,
    private val passwordValidator: PasswordValidator,
) {
    fun validate(form: RegisterForm): RegisterFormValidationResult {
        val firstNameRes = blankValidator.validate(form.firstName)
        val lastNameRes = blankValidator.validate(form.lastName)
        val middleNameRes = blankValidator.validate(form.middleName)

        val loginRes = loginValidator.validate(form.login)
        val emailRes = emailValidator.validate(form.email)
        val phoneRes = phoneValidator.validate(form.phone)
        val passwordRes = passwordValidator.validate(form.password)

        val isFormValid = firstNameRes.isValid && lastNameRes.isValid && middleNameRes.isValid &&
                loginRes.isValid && emailRes.isValid && phoneRes.isValid && passwordRes.isValid

        return RegisterFormValidationResult(
            isValid = isFormValid,
            firstNameErrors = firstNameRes.errors,
            lastNameErrors = lastNameRes.errors,
            middleNameErrors = middleNameRes.errors,
            loginErrors = loginRes.errors,
            emailErrors = emailRes.errors,
            phoneErrors = phoneRes.errors,
            passwordErrors = passwordRes.errors,
        )
    }
}