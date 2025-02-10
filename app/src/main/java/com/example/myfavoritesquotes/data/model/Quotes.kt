package com.example.myfavoritesquotes.data.model

import com.example.myfavoritesquotes.data.local.dao.EntityQuotes

data class Quotes(
    var quotes :String,
    var auteur : String,

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
