package com.example.myfavoritesquotes.glance.wigdet

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Box(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)

    ){
        for ( currentQuote in quoteList){
            Text(currentQuote.quotes)
            Text(currentQuote.auteur)
        }
    }
}


