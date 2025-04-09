package com.example.myfavoritesquotes.ui.navigation

import kotlinx.serialization.Serializable


sealed interface  Screen{
    @Serializable
    data object MainScreen:Screen

    @Serializable
    data object  AddScreen:Screen

}

