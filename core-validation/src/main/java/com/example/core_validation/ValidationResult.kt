package com.example.core_validation

data class ValidationResult(
    val isValid: Boolean,
    val errors: List<String> = emptyList()
)
