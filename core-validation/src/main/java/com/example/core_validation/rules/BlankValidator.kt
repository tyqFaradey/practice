package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class BlankValidator @Inject constructor() : Validator<String> {

    override fun validate(input: String): ValidationResult {
        val errors = mutableListOf<String>()

        if (input.isBlank()) {
            errors.add("Поле не должено быть пустым")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}