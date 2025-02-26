package com.example.myfavoritesquotes.data.repository

import android.util.Log
import com.example.myfavoritesquotes.data.local.dao.QuotesDao
import com.example.myfavoritesquotes.data.model.QuotesMapper
import com.example.myfavoritesquotes.data.model.QuotesModel

class QuotesRepository(private val quotesDao: QuotesDao) {

    suspend fun getAllQuotes():List<QuotesModel>{
        return try {
            val allQuotes = quotesDao.getAllQuotes()

                allQuotes.map{ QuotesMapper.toModel(it) }


        }catch (e:Exception){
            Log.e("pas de donnees", "donnnes introuvables")
            emptyList()
        }

    }
    suspend fun getRandomQuote():QuotesModel?{
      return  try {
            var quotes = quotesDao.getQuote()
          quotes?.let { QuotesMapper.toModel(it) }
        }catch (e:Exception){
            Log.e("erreur","")
          null
        }

    }
    fun createQuotes(){

    }


}