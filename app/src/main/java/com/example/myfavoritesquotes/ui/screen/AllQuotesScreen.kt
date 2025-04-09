package com.example.myfavoritesquotes.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.ui.viewModel.QuoteUiState
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel


@Composable
fun QuotesScreen(
    modifier: Modifier = Modifier,
    viewModel: QuoteViewModel = viewModel(),
    onNavigateToCreate: () -> Unit,
    onNavigateToEdit: (Long)-> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value


    when (val state = uiState) {
        is QuoteUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is QuoteUiState.Empty -> {
            EmptyQuotesView(
                modifier = modifier,
                onCreateClick = onNavigateToCreate
            )
        }
        is QuoteUiState.Success -> {
            AllQuotes(
                modifier = modifier,
                uiState = state,
                onEditClick = {  quote ->
                    // Gérer l'édition

                    onNavigateToEdit(quote.id)
                },
                onCreateClick = onNavigateToCreate
            )
        }
        is QuoteUiState.Error -> {
            ErrorView(
                message = state.message,
                modifier = modifier,
                onRetry = { viewModel.getAllQuotes() }
            )
        }

        else -> {}
    }
}

@Composable
fun AllQuotes(
    modifier: Modifier,
    uiState: QuoteUiState.Success,
    onEditClick: (QuotesModel) -> Unit,
    onCreateClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCreateClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Create, "Add Quote")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.quotes) { quote ->
                CardQuotes(
                    quotes = quote,
                    onEditClick = { onEditClick(quote) }
                )
            }
        }
    }
}

@Composable
fun CardQuotes(
    modifier: Modifier = Modifier,
    quotes: QuotesModel,
    onEditClick: () -> Unit
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
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(24.dp)
                )

                Text(
                    text = "- ${quotes.auteur}",
                    style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                    modifier = Modifier.align(Alignment.End)
                )
            }

            IconButton(
                onClick = onEditClick,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Quote"
                )
            }
        }
    }
}

@Composable
fun EmptyQuotesView(
    modifier: Modifier,
    onCreateClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Aucune citation disponible")
        Button(
            onClick = onCreateClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Créer une citation")
        }
    }
}

@Composable
fun ErrorView(
    message: String,
    modifier: Modifier,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Button(
            onClick = onRetry,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Réessayer")
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
        ), onEditClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAllQuotes() {

}


