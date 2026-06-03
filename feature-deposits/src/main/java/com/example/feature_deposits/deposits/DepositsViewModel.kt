package com.example.feature_deposits.deposits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_database.data.local.Deposit
import com.example.core_database.data.repository.DepositRepository
import com.example.core_session.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DepositsViewModel @Inject constructor(
    private val repository: DepositRepository,
    private val sessionRepository: SessionRepository,
) : ViewModel() {
    val userId = sessionRepository.getUserId()?.toInt()!!

    val deposits: StateFlow<List<Deposit>> =
        repository.getDepositsByUserId(userId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun clear() {
        viewModelScope.launch {
            repository.deleteDepositsByUserId(userId)
        }
    }
}