package com.example.myfavoritesquotes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfavoritesquotes.data.local.dao.QuotesDao
import com.example.myfavoritesquotes.data.local.entity.EntityQuotes
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [EntityQuotes::class], version = 1, exportSchema = false)
abstract class QuoteDatabase: RoomDatabase(){
            abstract fun QuotesDao():QuotesDao

            companion object{
                @Volatile private var INSTANCE:QuoteDatabase? =null

                fun getInstance(@ApplicationContext context: Context): QuoteDatabase {
                    return INSTANCE?:synchronized(this){
                        Room.databaseBuilder(
                            context.applicationContext,
                            QuoteDatabase::class.java,
                            "movie_database"
                        ).build()

                    }

                }
            }
}



