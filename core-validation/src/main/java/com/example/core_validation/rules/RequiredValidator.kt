package com.example.core_validation.rules

import com.example.core_validation.ValidationResult
import com.example.core_validation.Validator
import javax.inject.Inject

class RequiredValidator<T : Any> @Inject constructor() : Validator<T?> {
    override fun validate(input: T?): ValidationResult {
        val errors = mutableListOf<String>()

        if (input == null) {
            errors.add("Поле обязательно для заполнения")
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}