package com.example.myfavoritesquotes.data.local

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfavoritesquotes.data.local.dao.QuotesDao
import com.example.myfavoritesquotes.data.local.entity.EntityQuotes
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [EntityQuotes::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quotesDao(): QuotesDao // Nom de fonction en lowercase

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getInstance(context: Context): QuoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java,
                    "quotes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}



