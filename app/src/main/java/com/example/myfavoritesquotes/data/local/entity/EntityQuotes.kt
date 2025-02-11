package com.example.myfavoritesquotes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class EntityQuotes(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val quotes: String,
    val auteur: String

)
