package com.example.core_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.collections.isNotEmpty


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    label: String,
    value: String,
    errors: List<String>,
    onValueChange: (value: String) -> Unit,
) {
    val isError = errors.isNotEmpty()
    OutlinedTextField(
        label = { Text(label) },
        value = value,

        onValueChange = onValueChange,
        isError = isError,

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = PADDING, end = PADDING),
        singleLine = true,
    )
    if (isError) {
        ErrorsCard(errors)
    }
}