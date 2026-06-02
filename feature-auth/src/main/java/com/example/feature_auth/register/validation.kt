package com.example.feature_auth.register

import com.example.core_domain.Gender
import com.example.core_domain.schemas.Group
import com.example.core_validation.rules.BlankValidator
import com.example.core_validation.rules.EmailValidator
import com.example.core_validation.rules.LoginValidator
import com.example.core_validation.rules.PasswordValidator
import com.example.core_validation.rules.PhoneValidator
import com.example.core_validation.rules.RequiredSelectionValidator
import javax.inject.Inject

data class RegisterForm (
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val birthDate: String = "",
    val gender: Gender? = null,
    val group: Group? = null,

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
    val genderErrors: List<String> = emptyList(),
    val groupErrors: List<String> = emptyList(),

    val loginErrors: List<String> = emptyList(),
    val emailErrors: List<String> = emptyList(),
    val phoneErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),
)

class RegisterFormValidator @Inject constructor(
    private val blankValidator: BlankValidator,

    private val genderValidator: RequiredSelectionValidator<Gender>,
    private val groupValidator: RequiredSelectionValidator<Group>,

    private val loginValidator: LoginValidator,
    private val emailValidator: EmailValidator,
    private val phoneValidator: PhoneValidator,
    private val passwordValidator: PasswordValidator,
) {
    fun validate(form: RegisterForm): RegisterFormValidationResult {
        val firstNameRes = blankValidator.validate(form.firstName)
        val lastNameRes = blankValidator.validate(form.lastName)
        val middleNameRes = blankValidator.validate(form.middleName)
        val birthDateRes = blankValidator.validate(form.birthDate)

        val genderRes = genderValidator.validate(form.gender)
        val groupRes = groupValidator.validate(form.group)

        val loginRes = loginValidator.validate(form.login)
        val emailRes = emailValidator.validate(form.email)
        val phoneRes = phoneValidator.validate(form.phone)
        val passwordRes = passwordValidator.validate(form.password)

        val isFormValid = firstNameRes.isValid && lastNameRes.isValid && middleNameRes.isValid
                && birthDateRes.isValid && loginRes.isValid && emailRes.isValid && phoneRes.isValid
                && passwordRes.isValid && groupRes.isValid && genderRes.isValid

        return RegisterFormValidationResult(
            isValid = isFormValid,
            firstNameErrors = firstNameRes.errors,
            lastNameErrors = lastNameRes.errors,
            middleNameErrors = middleNameRes.errors,
            birthDateErrors = birthDateRes.errors,
            genderErrors = genderRes.errors,
            groupErrors = groupRes.errors,
            loginErrors = loginRes.errors,
            emailErrors = emailRes.errors,
            phoneErrors = phoneRes.errors,
            passwordErrors = passwordRes.errors,
        )
    }
}