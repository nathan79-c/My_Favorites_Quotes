package com.example.myfavoritesquotes.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
fun AllQuotes(modifier: Modifier, quotes: List<QuotesModel>, onClick: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle click */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Create, "Add Quote")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(quotes) { quote ->
                CardQuotes(quotes = quote, onEditClick = {})
            }
        }
    }
}


@Composable
fun CardQuotes(
    modifier: Modifier = Modifier,
    quotes: QuotesModel,
    onEditClick: () -> Unit // Add click handler
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = quotes.quotes,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(24.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "- ${quotes.auteur}",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            // Edit icon positioned at top-right
            IconButton(
                onClick = onEditClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(start = 48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Quote",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun ButtonFloating(modifier: Modifier,onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Create, "Floating action button.")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardQuotes() {
    CardQuotes(
        quotes = QuotesModel(
            quotes = "The only way to do great work is to love what you do.",
            auteur = "Steve Jobs"
        ), onEditClick = {}
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
  //  AllQuotes(quotes = sampleQuotes)
}


