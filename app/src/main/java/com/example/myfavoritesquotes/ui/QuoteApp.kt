package com.example.myfavoritesquotes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfavoritesquotes.ui.navigation.Screen
import com.example.myfavoritesquotes.ui.screen.AllQuotes
import com.example.myfavoritesquotes.ui.screen.QuotesScreen
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext

@Composable
fun QuoteApp(){
    KoinContext() {

        val navController = rememberNavController()
        val quoteViewModel: QuoteViewModel = koinViewModel()


        NavHost(
            navController = navController,
            startDestination = Screen.MainScreen
        ) {
            composable<Screen.MainScreen> {
                QuotesScreen(Modifier, quoteViewModel, onNavigateToCreate = {})
            }
        }
    }

}