package com.lunex.feature.dashboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardUiState(
    val isLoading: Boolean = false,
    val userName: String = "User",
    val stats: Map<String, String> = emptyMap()
)

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            _uiState.value = DashboardUiState(isLoading = true)
            
            // Simulate loading data
            // In a real app, you would fetch data from a repository
            val stats = mapOf(
                "Total Users" to "1,234",
                "Active Sessions" to "42",
                "Revenue" to "$12,345"
            )
            
            _uiState.value = DashboardUiState(
                isLoading = false,
                userName = "John Doe",
                stats = stats
            )
        }
    }
    
    fun refresh() {
        loadDashboardData()
    }
}
