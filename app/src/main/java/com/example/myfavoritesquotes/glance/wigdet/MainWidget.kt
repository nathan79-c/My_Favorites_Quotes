package com.example.myfavoritesquotes.glance.wigdet

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextAlign.Companion.Center
import androidx.glance.text.TextStyle
import com.example.myfavoritesquotes.R
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.data.repository.QuotesRepository

class MainWidget:GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {


            }
        }
    }
}

@Composable
fun MainWidget(repository: QuotesRepository) {
    var quotes by remember { mutableStateOf(emptyList<QuotesModel>()) }

    LaunchedEffect(Unit) {
        quotes = repository.getAllQuotes()

    }

}

