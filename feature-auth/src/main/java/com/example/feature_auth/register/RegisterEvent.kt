package com.example.feature_auth.register

import android.os.Message
import com.example.core_common.UiEvent

sealed interface RegisterEvent : UiEvent {
    data object AuthSuccess : RegisterEvent
    data object NavigateToLogin : RegisterEvent

}