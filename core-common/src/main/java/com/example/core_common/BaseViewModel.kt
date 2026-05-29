package com.example.core_common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<E:UiEvent, S:UiState>(
    initialState: S
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<E>()
    val event = _event.asSharedFlow()

    protected fun updateState(
        reducer: S.() -> S
    ) {
        _state.update(reducer)
    }

    protected suspend fun sendEvent(
        event: E
    ) {
        _event.emit(event)
    }
}