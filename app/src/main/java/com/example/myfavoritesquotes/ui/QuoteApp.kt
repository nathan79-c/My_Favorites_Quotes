package com.example.myfavoritesquotes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myfavoritesquotes.ui.navigation.Screen
import com.example.myfavoritesquotes.ui.screen.QuotesElement
import com.example.myfavoritesquotes.ui.screen.QuotesScreen
import com.example.myfavoritesquotes.ui.viewModel.QuoteViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext

@Composable
fun QuoteApp(){


        val navController = rememberNavController()
        val quoteViewModel: QuoteViewModel = koinViewModel()





        NavHost(
            navController = navController,
            startDestination = Screen.MainScreen
        ) {
            composable<Screen.MainScreen> {
                QuotesScreen(Modifier, quoteViewModel, onNavigateToCreate = {
                    quoteViewModel.clearSelectedQuote()
                    navController.navigate(
                        Screen.AddScreen
                    )
                },
                    onNavigateToEdit = { quoteId ->
                        quoteViewModel.prepareUpdate(quoteId)
                        navController.navigate(Screen.AddScreen)
                    })
            }
            composable<Screen.AddScreen> {
                QuotesElement(
                    viewModel = quoteViewModel,
                    navController = navController
                )
            }
        }


}