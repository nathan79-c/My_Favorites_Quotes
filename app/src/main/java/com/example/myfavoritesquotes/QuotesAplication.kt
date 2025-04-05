package com.example.myfavoritesquotes

import android.app.Application
import com.example.myfavoritesquotes.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.androix.startup.KoinStartup
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.KoinConfiguration


@OptIn(KoinExperimentalAPI::class)
class QuotesAplication  : Application() , KoinStartup {
    override fun onKoinStartup()= KoinConfiguration {
        androidContext(this@QuotesAplication)
        modules(appModule)
    }
   override fun onCreate() {
        super.onCreate()


    }
}

