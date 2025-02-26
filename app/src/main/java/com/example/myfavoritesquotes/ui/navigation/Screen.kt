package com.example.myfavoritesquotes.ui.navigation

import kotlinx.serialization.Serializable
sealed class  Screen{
    @Serializable
    data object mainScreen:Screen


    @Serializable
    data object  addScreen:Screen
}