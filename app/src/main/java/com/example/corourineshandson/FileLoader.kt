package com.example.corourineshandson

import android.content.Context
import androidx.annotation.RawRes
import com.example.corourineshandson.entities.Genres
import com.example.corourineshandson.entities.MoviesResults
import com.google.gson.Gson
import java.io.InputStreamReader

class FileLoader(
    val context: Context,
    val gson: Gson
) {

    fun loadMovies(): MoviesResults {
        context.resources.openRawResource(MoviesFile.file).use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                return gson.fromJson(inputStreamReader, MoviesResults::class.java)
            }
        }
    }

    fun loadGenres(): Genres {
        context.resources.openRawResource(GeneresFile.file).use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                return gson.fromJson(inputStreamReader, Genres::class.java)
            }
        }
    }


}

sealed class FileToLoad<Type>(@RawRes val file: Int, type: Class<Type>)
object MoviesFile : FileToLoad<MoviesResults>(R.raw.movies, MoviesResults::class.java)
object GeneresFile : FileToLoad<Genres>(R.raw.genres, Genres::class.java)