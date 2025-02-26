package com.example.myfavoritesquotes.di

import com.example.myfavoritesquotes.data.local.QuoteDatabase
import org.koin.dsl.module

val appModule = module {
    single { QuoteDatabase.getInstance(get()) }
    single { get<QuoteDatabase>().QuotesDao() }

}