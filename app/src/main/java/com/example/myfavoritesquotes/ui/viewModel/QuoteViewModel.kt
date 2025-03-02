package com.example.myfavoritesquotes.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.data.repository.QuotesRepository

class QuoteViewModel(private val quotesRepository:QuotesRepository):ViewModel() {

}

sealed class QuoteUiState{
    object Loading:QuoteUiState()
    data class  Error(val message:String):QuoteUiState()
    data class Succes(
        val Quotes:List<QuotesModel>,
        val selectQuote:QuotesModel?= null
    ):QuoteUiState()
}