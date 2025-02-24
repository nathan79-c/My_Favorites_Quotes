package com.example.myfavoritesquotes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfavoritesquotes.data.model.QuotesModel

@Composable
fun AllQuotes(modifier: Modifier = Modifier, quotes: List<QuotesModel>) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(quotes) { quote ->
            CardQuotes(quotes = quote)
        }
    }
}

@Composable
fun CardQuotes(modifier: Modifier = Modifier, quotes: QuotesModel) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quotes.quotes,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- ${quotes.auteur}",
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardQuotes() {
    CardQuotes(
        quotes = QuotesModel(
            quotes = "The only way to do great work is to love what you do.",
            auteur = "Steve Jobs"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAllQuotes() {
    val sampleQuotes = listOf(
        QuotesModel("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"),
        QuotesModel("Do what you can, with what you have, where you are.", "Theodore Roosevelt"),
        QuotesModel("In the middle of every difficulty lies opportunity.", "Albert Einstein")
    )
    AllQuotes(quotes = sampleQuotes)
}


