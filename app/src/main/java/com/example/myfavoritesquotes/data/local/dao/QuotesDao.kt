package com.example.myfavoritesquotes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.Update
import com.example.myfavoritesquotes.data.local.entity.EntityQuotes


@Dao

interface QuotesDao {

    // Insert a new quote
    @Insert
    suspend fun insertQuote(quote: EntityQuotes)

    @Update
    suspend fun upadateQuote(quote: EntityQuotes)

    @Delete
    suspend fun deleteQuote(quote: EntityQuotes)

    // Get all quotes
    @Query("SELECT * FROM quotes")
    suspend fun getAllQuotes(): List<EntityQuotes>

    // Get a quote by its ID
    @Query("SELECT * FROM quotes WHERE id = :id LIMIT 1")
    suspend fun getQuoteById(id: Int): EntityQuotes?


    // GET RADOM QUOTES
    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1 ")
    suspend fun  getQuote():EntityQuotes
}