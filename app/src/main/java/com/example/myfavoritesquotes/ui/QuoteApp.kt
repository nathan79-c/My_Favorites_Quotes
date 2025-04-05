package com.example.myfavoritesquotes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfavoritesquotes.ui.navigation.Screen
import com.example.myfavoritesquotes.ui.screen.AllQuotes

@Composable
fun QuoteApp(){

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ""
    ) {
        composable<Screen.MainScreen> {
          // AllQuotes()
        }
    }

}