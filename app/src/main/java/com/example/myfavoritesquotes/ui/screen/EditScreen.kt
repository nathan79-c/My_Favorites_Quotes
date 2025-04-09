package com.example.myfavoritesquotes.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myfavoritesquotes.R
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.ui.viewModel.QuoteUiState
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun QuotesElement(
    modifier: Modifier = Modifier,
    viewModel: QuoteViewModel,
    navController: NavController
) {
    val selectedQuote by viewModel.selectedQuote.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var auteur by remember { mutableStateOf(selectedQuote?.auteur ?: "") }
    var content by remember { mutableStateOf(selectedQuote?.quotes ?: "") }

    val isSaving = uiState is QuoteUiState.Saving
    var showConfetti by remember { mutableStateOf(false) }
    var showExitConfirmation by remember { mutableStateOf(false) }

    // Animation d'entrée
    val enterTransition = remember {
        fadeIn(animationSpec = tween(600)) + slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 })
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f)) // Effet estompé
    ) {
        AnimatedVisibility(
            visible = true,
            enter = enterTransition
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 120.dp, start = 16.dp, end = 16.dp)
                    .animateContentSize(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (selectedQuote == null) "Créer une citation" else "Modifier la citation",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = auteur,
                        onValueChange = { auteur = it },
                        label = { Text("Auteur") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        label = { Text("Citation") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        maxLines = 5
                    )

                    if (isSaving) {
                        CircularProgressIndicator()
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            OutlinedButton(
                                onClick = {
                                    showExitConfirmation = true
                                },
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                            ) {
                                Icon(Icons.Default.Close, contentDescription = "Annuler")
                                Spacer(Modifier.width(6.dp))
                                Text("Annuler")
                            }

                            Button(
                                onClick = {
                                    val newQuote = QuotesModel(
                                        id = selectedQuote?.id ?: 0L,
                                        auteur = auteur,
                                        quotes = content
                                    )

                                    scope.launch {
                                        if (selectedQuote == null) {
                                            viewModel.createQuote(newQuote)
                                        } else {
                                            viewModel.updateQuote(newQuote)
                                        }

                                        showConfetti = true // 🎉
                                        snackbarHostState.showSnackbar("Citation enregistrée !")

                                        delay(2000) // Laisse le temps à l’animation
                                        showConfetti = false

                                        viewModel.clearSelectedQuote()
                                        navController.popBackStack()
                                    }
                                },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(24.dp),
                                elevation = ButtonDefaults.elevatedButtonElevation(8.dp)
                            ) {
                                Icon(Icons.Default.Done, contentDescription = "Enregistrer")
                                Spacer(Modifier.width(6.dp))
                                Text("Enregistrer", fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }

        // 🎉 Confetti Animation
        if (showConfetti) {
            LottieAnimationConfetti()
        }

        // Snackbar
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }

    // 🔒 Confirmation avant de quitter sans enregistrer
    if (showExitConfirmation) {
        AlertDialog(
            onDismissRequest = { showExitConfirmation = false },
            title = { Text("Annuler ?") },
            text = { Text("Voulez-vous vraiment quitter sans enregistrer ?") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.clearSelectedQuote()
                    navController.popBackStack()
                }) {
                    Text("Oui")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showExitConfirmation = false
                }) {
                    Text("Non")
                }
            }
        )
    }
}


@Composable
fun LottieAnimationConfetti() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.confetti))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1,
        speed = 1.5f
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .zIndex(2f)
    )
}












@Preview(showBackground = true)
@Composable
fun QuotesElementPreview() {
  //  QuotesElement(modifier = Modifier.fillMaxSize())
}

