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
    fun createQuote(quotesModel: QuotesModel) {
        viewModelScope.launch {
            try {
                _uiState.value = QuoteUiState.Creating
                quotesRepository.createQuote(quotesModel)
                getAllQuotes() // Rafraîchit la liste après création
            } catch (e: Exception) {
                _uiState.value = QuoteUiState.Error("Erreur de création : ${e.message}")
            }
        }
    }

    private val _selectedQuote = MutableStateFlow<QuotesModel?>(null)
    val selectedQuote: StateFlow<QuotesModel?> = _selectedQuote.asStateFlow()

    fun prepareUpdate(quote: QuotesModel) {
        _selectedQuote.value = quote
        // Naviguer vers un écran d'édition
    }

    suspend fun updateQuote(updatedQuote: QuotesModel) {
        try {
            quotesRepository.updateQuote(updatedQuote)
            getAllQuotes() // Rafraîchit la liste
        } catch (e: Exception) {
            _uiState.value = QuoteUiState.Error("Erreur de mise à jour")
        }
    }

}

// États possibles
sealed class QuoteUiState {
    object Loading : QuoteUiState()
    object Creating : QuoteUiState()
    object Empty : QuoteUiState() // Nouvel état pour données vides
    data class Success(val quotes: List<QuotesModel>) : QuoteUiState()
    data class Error(val message: String) : QuoteUiState()
}