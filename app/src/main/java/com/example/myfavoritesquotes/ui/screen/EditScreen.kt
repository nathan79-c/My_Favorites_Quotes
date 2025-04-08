package com.example.myfavoritesquotes.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfavoritesquotes.data.model.QuotesModel

// 1. Modifier le composable QuotesElement
@Composable
fun QuotesElement(
    modifier: Modifier = Modifier,
    quote: QuotesModel? = null,
    onSave: (QuotesModel) -> Unit
) {
    var auteur by remember { mutableStateOf(quote?.auteur ?: "") }
    var content by remember { mutableStateOf(quote?.quotes ?: "") }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 120.dp, start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (quote == null) "Create a New Quote" else "Edit Quote",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = auteur,
                onValueChange = { auteur = it },
                label = { Text("Author") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Quote") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                maxLines = 5
            )

            ElevatedButton(
                onClick = {
                    val newQuote = QuotesModel(
                        auteur = auteur,
                        quotes = content
                    )
                    onSave(newQuote)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Save", fontSize = 18.sp)
            }
        }
    }
}









@Preview(showBackground = true)
@Composable
fun QuotesElementPreview() {
  //  QuotesElement(modifier = Modifier.fillMaxSize())
}

