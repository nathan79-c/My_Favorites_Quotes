package com.example.myfavoritesquotes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import com.example.myfavoritesquotes.data.local.entity.EntityQuotes


@Dao

interface QuotesDao {

    // Insert a new quote
    @Insert
    suspend fun insertQuote(quote: EntityQuotes)

    // Get all quotes
    @Query("SELECT * FROM quotes")
    suspend fun getAllQuotes(): List<EntityQuotes>

    // Get a quote by its ID
    @Query("SELECT * FROM quotes WHERE id = :id LIMIT 1")
    suspend fun getQuoteById(id: Long): EntityQuotes?

    // Delete a quote by its ID
    @Query("DELETE FROM quotes WHERE id = :id")
    suspend fun deleteQuoteById(id: Long)
}