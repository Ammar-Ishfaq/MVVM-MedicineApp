package com.ammar.ishfaq.drugs.ui.home

import com.ammar.ishfaq.drugs.models.drugs.Drugs

/**
 * Sealed class to represent UI states in [HomeScreen]
 */
sealed interface HomeScreenUiState {
    data object Initial : HomeScreenUiState
    data object Loading : HomeScreenUiState
    data class Success(val obj: Drugs) : HomeScreenUiState
    data class Error(val msg: String) : HomeScreenUiState
}
