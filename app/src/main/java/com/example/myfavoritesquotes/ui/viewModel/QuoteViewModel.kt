package com.example.myfavoritesquotes.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.data.repository.QuotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuoteViewModel(private val quotesRepository:QuotesRepository):ViewModel() {
    private  val _uiState = MutableStateFlow<QuoteUiState>(QuoteUiState.Loading)
    val uiState:StateFlow<QuoteUiState> = _uiState.asStateFlow()

}

sealed class QuoteUiState{
    object Loading:QuoteUiState()
    data class  Error(val message:String):QuoteUiState()
    data class Succes(
        val Quotes:List<QuotesModel>,
        val selectQuote:QuotesModel?= null
    ):QuoteUiState()
}