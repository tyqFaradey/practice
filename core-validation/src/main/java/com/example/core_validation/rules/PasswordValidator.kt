package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class PasswordValidator @Inject constructor(
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

        if (input.length < 8) {
            errors.add("Пароль должен содержать минимум 8 символов")
        }
//        if (!input.any { it.isUpperCase() }) {
//            errors.add("Пароль должен содержать хотя бы одну заглавную букву")
//        }
        if (!input.any { it.isLowerCase() }) {
            errors.add("Пароль должен содержать хотя бы одну строчную букву")
        }
        if (!input.any { it.isDigit() }) {
            errors.add("Пароль должен содержать хотя бы одну цифру")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}