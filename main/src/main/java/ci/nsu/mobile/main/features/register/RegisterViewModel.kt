package ci.nsu.mobile.main.features.register

import javax.inject.Inject

import android.util.Log

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import ci.nsu.mobile.main.core.navigation.Screen
import ci.nsu.mobile.main.data.repository.AuthRepository
import ci.nsu.mobile.main.data.repository.GroupRepository
import ci.nsu.mobile.main.features.login.LoginEvent
import ci.nsu.mobile.main.features.login.LoginState
import ci.nsu.mobile.main.model.dto.RegisterRequest


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val groupRepository: GroupRepository,
): ViewModel() {
    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()
}