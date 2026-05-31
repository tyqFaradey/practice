package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class EmailValidator @Inject constructor(
    private val blankValidator: BlankValidator
) : Validator<String> {
    private val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()

    override fun validate(input: String): ValidationResult {
        val blankResult = blankValidator.validate(input)
        val errors = blankResult.errors.toMutableList()

        if (!blankResult.isValid) {
            return ValidationResult(
                isValid = errors.isEmpty(),
                errors = errors
            )
        }
        if (!input.matches(emailRegex)) {
            errors.add("Неверный формат электронной почты")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}