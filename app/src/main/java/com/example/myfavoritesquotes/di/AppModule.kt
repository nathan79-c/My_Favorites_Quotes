package com.example.myfavoritesquotes.di

import com.example.myfavoritesquotes.data.local.QuoteDatabase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel
import org.koin.core.module.dsl.singleOf

val appModule = module {
    single { QuoteDatabase.getInstance(get()) }
    single { get<QuoteDatabase>().QuotesDao() }
    viewModelOf(::QuoteViewModel)

}