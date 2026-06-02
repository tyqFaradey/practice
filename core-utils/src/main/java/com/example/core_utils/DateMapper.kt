package com.example.core_utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


import com.example.core_domain.API_DATE_FORMAT
import com.example.core_domain.UI_DATE_FORMAT

object DateMapper {
    private val uiFormatter = DateTimeFormatter.ofPattern(UI_DATE_FORMAT)
    private val apiFormatter = DateTimeFormatter.ofPattern(API_DATE_FORMAT)

    fun mapUiDateToApi(uiDate: String): String {
        val date = LocalDate.parse(uiDate, uiFormatter)
        return date.format(apiFormatter)
    }
}