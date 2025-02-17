package com.example.myfavoritesquotes.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.myfavoritesquotes.data.model.QuotesModel

interface QuotesDao {

    // Insert a new quote
    @Insert
    suspend fun insertQuote(quote: QuotesModel)

    // Get all quotes
    @Query("SELECT * FROM quotes")
    suspend fun getAllQuotes(): List<QuotesModel>

    // Get a quote by its ID
    @Query("SELECT * FROM quotes WHERE id = :id LIMIT 1")
    suspend fun getQuoteById(id: Long): QuotesModel?

    // Delete a quote by its ID
    @Query("DELETE FROM quotes WHERE id = :id")
    suspend fun deleteQuoteById(id: Long)
}