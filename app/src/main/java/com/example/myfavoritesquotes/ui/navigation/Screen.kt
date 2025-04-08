package com.example.myfavoritesquotes.ui.navigation

import com.example.myfavoritesquotes.data.model.QuotesModel
import kotlinx.serialization.Serializable


sealed interface  Screen{
    @Serializable
    data object MainScreen:Screen


    @Serializable
    data object  AddScreen:Screen
        fun withQuote(quote: QuotesModel)="$this/$quote"
}

