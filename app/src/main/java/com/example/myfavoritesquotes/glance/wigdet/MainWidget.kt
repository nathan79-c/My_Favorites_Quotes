package com.example.myfavoritesquotes.glance.wigdet

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.text.Text
import com.example.myfavoritesquotes.data.model.QuotesModel

class MainWidget:GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
            }
        }
    }
}

@Composable
fun widgetScreen(modifier: Modifier,quoteList:List<QuotesModel>){
    Box(modifier = modifier){
        for ( currentQuote in quoteList){
            Text(currentQuote.quotes)
            Text(currentQuote.auteur)
        }
    }
}


