package com.example.corourineshandson

import com.example.corourineshandson.entities.Genres
import com.example.corourineshandson.entities.MoviesResults
import com.example.corourineshandson.ui_entities.Movie
import kotlinx.coroutines.*

class Presenter(
    private val mainActivity: MainActivity,
    private val fileLoader: FileLoader,
    private val scope: CoroutineScope = MainScope()
) {

    fun start() {
        scope.launch {

            val movies = fileLoader.loadMovies() // Blocking (not suspending)

            val genres = fileLoader.loadGenres() // Blocking (not suspending)

            val uiMovies = parseDataToUiMovie(movies, genres.toMap()) // Blocking

            mainActivity.showMovies(uiMovies)
        }
    }

    private fun parseDataToUiMovie(
        movies: MoviesResults,
        genres: Map<Int, String>
    ): MutableList<Movie> {
        val uiMovies = mutableListOf<Movie>()
        movies.results.forEach {
            uiMovies.add(
                Movie(
                    it.title,
                    it.genre_ids.map { genre -> genres.getValue(genre) }
                )
            )
        }
        return uiMovies
    }
}

private fun Genres.toMap(): Map<Int, String> {
    val map = mutableMapOf<Int, String>()
    this.genres.forEach {
        map[it.id] = it.name
    }
    return map
}