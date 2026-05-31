package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class PhoneValidator @Inject constructor(
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

        if (input.length < 10) {
            errors.add("Телефон должен содержать минимум 10 символов")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}