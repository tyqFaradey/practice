package com.example.core_validation

interface Validator<T> {
    fun validate(input: T): ValidationResult
}