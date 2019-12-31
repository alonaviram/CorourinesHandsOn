package com.example.corourineshandson

import android.content.Context
import androidx.annotation.RawRes
import com.example.corourineshandson.entities.Genres
import com.example.corourineshandson.entities.MoviesResults
import com.google.gson.Gson
import java.io.InputStreamReader

class FileLoader(
    private val context: Context,
    private val gson: Gson
) {

    fun loadMovies(): MoviesResults {

        Thread.sleep(3000) // simulate long time

        context.resources.openRawResource(MoviesFile.file).use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                return gson.fromJson(inputStreamReader, MoviesResults::class.java)
            }
        }
    }

    fun loadGenres(): Genres {

        Thread.sleep(3000) // simulate long time

        context.resources.openRawResource(GenresFile.file).use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                return gson.fromJson(inputStreamReader, Genres::class.java)
            }
        }
    }
}

sealed class FileToLoad(@RawRes val file: Int)
object MoviesFile : FileToLoad(R.raw.movies)
object GenresFile : FileToLoad(R.raw.genres)