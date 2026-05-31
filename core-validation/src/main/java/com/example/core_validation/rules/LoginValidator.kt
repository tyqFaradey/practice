package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class LoginValidator @Inject constructor(
    private val blankValidator: BlankValidator
) : Validator<String> {

    override fun validate(input: String): ValidationResult {
        val blankResult = blankValidator.validate(input)
        val errors = blankResult.errors.toMutableList()

        if (!blankResult.isValid) {
            return ValidationResult(
                isValid = errors.isEmpty(),
                errors = errors
            )
        }

        if (input.length < 3) {
            errors.add("Логин должен содержать минимум 3 символа")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}