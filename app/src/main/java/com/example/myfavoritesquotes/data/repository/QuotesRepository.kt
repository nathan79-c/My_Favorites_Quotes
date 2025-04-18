package com.example.myfavoritesquotes.data.repository

import android.util.Log
import com.example.myfavoritesquotes.data.local.dao.QuotesDao
import com.example.myfavoritesquotes.data.model.QuotesMapper
import com.example.myfavoritesquotes.data.model.QuotesModel

class QuotesRepository(private val quotesDao: QuotesDao) {

    suspend fun getAllQuotes(): List<QuotesModel> { // Retirez le nullable si possible
        return try {
            quotesDao.getAllQuotes()
                .map { QuotesMapper.toModel(it) } // Utilisez mapNotNull pour filtrer les nulls
        } catch (e: Exception) {
            Log.e("QuotesRepository", "Error getting quotes", e)
            emptyList()
        }
    }
    suspend fun getRandomQuote():QuotesModel?{
      return  try {
            var quotes = quotesDao.getQuote()
          quotes.let { QuotesMapper.toModel(it) }
        }catch (e:Exception){
            Log.e("erreur","${e.message}")
          null
        }

    }
    suspend  fun createQuote(quotesModel: QuotesModel){
        var quote = quotesModel.let { QuotesMapper.toEntity(it) }
        quotesDao.insertQuote(quote)

    }
    suspend fun getQuoteById(quoteId: Long): QuotesModel?{
        return  try {
            var quotes = quotesDao.getQuoteById(quoteId)
            quotes.let{ QuotesMapper.toModel(it) }
        }catch (e: Exception){
            Log.e("Erreur","${e.message}")
            null
        }
    }

    suspend fun  updateQuote(updatedQuote: QuotesModel){
        var quote = updatedQuote.let { QuotesMapper.toEntity(it) }
        quotesDao.upadateQuote(quote)

    }
}