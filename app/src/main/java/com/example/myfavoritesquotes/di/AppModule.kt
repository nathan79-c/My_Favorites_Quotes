package com.example.myfavoritesquotes.di

import com.example.myfavoritesquotes.data.local.QuoteDatabase
import com.example.myfavoritesquotes.data.repository.QuotesRepository
import org.koin.dsl.module
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel


val appModule = module {
    single { QuoteDatabase.getInstance(get()) }
    single { get<QuoteDatabase>().QuotesDao() }
    single { QuotesRepository(get()) }
    factory { QuoteViewModel(get()) }

}