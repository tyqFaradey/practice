package ci.nsu.mobile.main.core.utils

object Validator {
    fun validateUsername(value: String) : List<String> {
        val errors = mutableListOf<String>()
        if (value.isBlank()) errors.add("Логин обязателен")
        if (value.length < 3) errors.add("Минимум 3 символа")
        return errors
    }

    fun validatePassword(value: String) : List<String> {
        val errors = mutableListOf<String>()
        if (value.isBlank()) errors.add("Пароль обязателен")
        if (value.length < 8) errors.add("Минимум 8 символов")
        if (!value.any { it.isUpperCase() }) errors.add("Нет заглавной буквы")
        if (!value.any { it.isLowerCase() }) errors.add("Нет строчной буквы")
        if (!value.any { it.isDigit() }) errors.add("Нет цифры")
        return errors
    }

    fun validateEmail(value: String): List<String> {
        val errors = mutableListOf<String>()
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) { errors.add("Невалидный адрес электронной почты") }
        return errors
    }

    fun validatePhone(value: String): List<String> {
        val errors = mutableListOf<String>()
        if (value.length < 10) errors.add("Невалидный номер телефона")
        return errors
    }

    val validators: Map<Field, (String) -> List<String>> = mapOf(
        Field.USERNAME to Validator::validateUsername,
        Field.PASSWORD to Validator::validatePassword,
        Field.EMAIL to Validator::validateEmail,
        Field.PHONE to Validator::validatePhone
    )
}

enum class Field {
    USERNAME,
    PASSWORD,
    EMAIL,
    PHONE
}