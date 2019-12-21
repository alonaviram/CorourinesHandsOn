package com.example.corourineshandson.entities

data class MoviesResults(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)