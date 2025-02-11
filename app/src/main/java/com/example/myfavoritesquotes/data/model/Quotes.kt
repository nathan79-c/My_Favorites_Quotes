package com.example.myfavoritesquotes.data.model

import com.example.myfavoritesquotes.data.local.entity.EntityQuotes

data class Quotes(
    val quotes :String,
    val auteur : String,

)

object QuotesMapper {

    // Convert EntityQuotes to Quotes
    fun toModel(entityQuotes: EntityQuotes): Quotes {
        return Quotes(
            quotes = entityQuotes.quotes,
            auteur = entityQuotes.auteur
        )
    }

    // Convert Quotes to EntityQuotes
    fun toEntity(quotes: Quotes): EntityQuotes {
        return EntityQuotes(
            quotes = quotes.quotes,
            auteur = quotes.auteur
        )
    }
}
