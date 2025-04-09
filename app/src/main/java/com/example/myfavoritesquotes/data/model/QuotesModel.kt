package com.example.myfavoritesquotes.data.model

import com.example.myfavoritesquotes.data.local.entity.EntityQuotes

data class QuotesModel(
    val quotes :String,
    val auteur : String,
    val id : Long = 0

)

object QuotesMapper {

    // Convert EntityQuotes to Quotes
    fun toModel(entityQuotes: EntityQuotes?): QuotesModel {
        return QuotesModel(
            quotes = entityQuotes!!.quotes,
            auteur = entityQuotes.auteur,
            id = entityQuotes.id
        )
    }

    // Convert Quotes to EntityQuotes
    fun toEntity(quotes: QuotesModel): EntityQuotes {
        return EntityQuotes(
            quotes = quotes.quotes,
            auteur = quotes.auteur,
            id = quotes.id
        )
    }
}
