package com.example.myfavoritesquotes.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.data.repository.QuotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(private val quotesRepository:QuotesRepository):ViewModel() {
    private  val _uiState = MutableStateFlow<QuoteUiState>(QuoteUiState.Loading)
    val uiState:StateFlow<QuoteUiState> = _uiState.asStateFlow()

    init {
        getAllQuotes()
    }

    fun getAllQuotes() {
        viewModelScope.launch {
            _uiState.value = QuoteUiState.Loading
            try {
                val result = quotesRepository.getAllQuotes()

                if (result.isEmpty()) {
                    _uiState.value = QuoteUiState.Empty
                } else {
                    _uiState.value = QuoteUiState.Success(result)
                }
            } catch (e: Exception) {
                _uiState.value = QuoteUiState.Error("Error loading quotes: ${e.message}")
            }
        }
    }
    fun glanceNewQuotes(){

    }

}

// États possibles
sealed class QuoteUiState {
    object Loading : QuoteUiState()
    object Empty : QuoteUiState() // Nouvel état pour données vides
    data class Success(val quotes: List<QuotesModel>) : QuoteUiState()
    data class Error(val message: String) : QuoteUiState()
}