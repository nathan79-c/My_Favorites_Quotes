package com.example.myfavoritesquotes

import android.app.Application
import com.example.myfavoritesquotes.di.appModule
import org.koin.core.context.GlobalContext.startKoin


class QuotesAplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@QuotesAplication)
            modules(appModule)
        }

    }
}