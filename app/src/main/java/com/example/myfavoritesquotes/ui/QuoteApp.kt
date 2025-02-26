package com.example.myfavoritesquotes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun QuoteApp(){

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ""
    ) {

    }

}