package com.example.myfavoritesquotes.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.myfavoritesquotes.data.model.Quotes

interface QuotesDao {

    // Insert a new quote
    @Insert
    suspend fun insertQuote(quote: Quotes)

    // Get all quotes
    @Query("SELECT * FROM quotes")
    suspend fun getAllQuotes(): List<Quotes>

    // Get a quote by its ID
    @Query("SELECT * FROM quotes WHERE id = :id LIMIT 1")
    suspend fun getQuoteById(id: Long): Quotes?

    // Delete a quote by its ID
    @Query("DELETE FROM quotes WHERE id = :id")
    suspend fun deleteQuoteById(id: Long)
}