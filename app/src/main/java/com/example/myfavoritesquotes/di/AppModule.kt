package com.example.myfavoritesquotes.di

import com.example.myfavoritesquotes.data.local.QuoteDatabase
import com.example.myfavoritesquotes.data.repository.QuotesRepository
import org.koin.dsl.module
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf


val appModule = module {
    single { QuoteDatabase.getInstance(get()) }
    single { get<QuoteDatabase>().quotesDao()} // Assurez-vous que le nom correspond exactement
    single { QuotesRepository(get()) }
    viewModel { QuoteViewModel(get()) }

}