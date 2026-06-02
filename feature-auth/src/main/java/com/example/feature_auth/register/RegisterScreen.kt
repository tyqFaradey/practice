package com.example.feature_auth.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core_domain.Gender
import com.example.core_domain.UI_DATE_FORMAT
import com.example.core_domain.schemas.Group

import com.example.core_ui.BaseScreen
import com.example.core_ui.ButtonsPanel
import com.example.core_ui.Link
import com.example.core_ui.TextField
import com.example.core_ui.DatePickerField
import com.example.core_ui.Dropdown
import com.example.core_ui.PADDING

@Composable
fun RegisterScreen(
    state: RegisterState,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onMiddleNameChanged: (String) -> Unit,
    onBirthDateChanged: (String) -> Unit,
    onGenderChanged: (Gender?) -> Unit,
    onGroupChanged: (Group?) -> Unit,
    onLoginChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onToLogin: () -> Unit
) {
    BaseScreen(
        title = "Вход",
        bottomBar = {
            Column(
                modifier = Modifier
                    .imePadding()
                    .padding(PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(PADDING)
            ) {
                ButtonsPanel {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onRegisterClick
                    ) {
                        Text("Зарегистрироваться")
                    }
                }
                Link(
                    text = "Вход",
                    onClicked = onToLogin
                )

            }
        }
    ) {
        TextField(
            label = "Имя",
            value = state.firstName,
            errors = state.firstNameErrors,
            onValueChange = onFirstNameChanged
        )

        TextField(
            label = "Фамилия",
            value = state.lastName,
            errors = state.lastNameErrors,
            onValueChange = onLastNameChanged
        )
        TextField(
            label = "Отчество",
            value = state.middleName,
            errors = state.middleNameErrors,
            onValueChange = onMiddleNameChanged
        )

        DatePickerField(
            label = "Дата рождения",
            value = state.birthDate,
            errors = state.birthDateErrors,
            onDateSelect = onBirthDateChanged,
            dateFormat = UI_DATE_FORMAT
        )

        Dropdown(
            label = "Выберите пол",
            items = Gender.entries.toList(),
            selected = state.gender,
            onSelect = onGenderChanged,
            itemLabel = {
                when(it) {
                    Gender.MALE -> "Мужской"
                    Gender.FEMALE -> "Женский"
                }
            },
            errors = state.genderErrors
        )

        Dropdown(
            label = "Выберите группу",
            items = state.groups,
            selected = state.group,
            onSelect = onGroupChanged,
            itemLabel = { it.name },
            errors = state.groupErrors
        )

        TextField(
            label = "Логин",
            value = state.login,
            errors = state.loginErrors,
            onValueChange = onLoginChanged
        )
        TextField(
            label = "Почта",
            value = state.email,
            errors = state.emailErrors,
            onValueChange = onEmailChanged
        )
        TextField(
            label = "Телефон",
            value = state.phone,
            errors = state.phoneErrors,
            onValueChange = onPhoneChanged
        )
        TextField(
            label = "Пароль",
            value = state.password,
            errors = state.passwordErrors,
            onValueChange = onPasswordChanged
        )
    }
}