package com.example.myfavoritesquotes.glance.wigdet

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextAlign.Companion.Center
import androidx.glance.text.TextStyle
import com.example.myfavoritesquotes.R
import com.example.myfavoritesquotes.data.model.QuotesModel

class MainWidget:GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                var quotes= QuotesModel("La question de notre époque est la répartition adéquate des fortunes\n" +
                        "afin que les liens de fraternité puissent continuer à maintenir ensemble\n" +
                        "les riches et les pauvres en relations harmonieuses.","CAndrew Carnegie")

                GlanceQuotesCard(quotes = quotes)
            }
        }
    }
}

@Composable
fun GlanceQuotesCard(
    quotes: QuotesModel,

) {
    androidx.glance.layout.Column(
        modifier = GlanceModifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(R.color.background),

        content = {
            androidx.glance.layout.Column(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = androidx.glance.layout.Alignment.CenterHorizontally
            ) {
                Text(
                    text = quotes.quotes,
                    style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = Center,

                    ),
                    modifier = GlanceModifier.fillMaxWidth()
                )

                androidx.glance.layout.Spacer(modifier =GlanceModifier.height(8.dp))

                Text(
                    text = "- ${quotes.auteur}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontStyle = androidx.glance.text.FontStyle.Italic,
                        textAlign = androidx.glance.text.TextAlign.End,

                    ),
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )
            }


        }
    )
}

