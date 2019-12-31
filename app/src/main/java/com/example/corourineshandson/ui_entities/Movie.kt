package com.example.corourineshandson.ui_entities

data class Movie(
    val name: String,
    val genres: List<String> = emptyList()
)
