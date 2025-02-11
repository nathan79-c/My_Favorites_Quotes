package com.example.myfavoritesquotes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfavoritesquotes.data.local.dao.QuotesDao
import com.example.myfavoritesquotes.data.local.entity.EntityQuotes

@Database(entities = [EntityQuotes::class], version = 1, exportSchema = false)
abstract class QuoteDatabase: RoomDatabase(){
            abstract fun QuotesDao():QuotesDao
}