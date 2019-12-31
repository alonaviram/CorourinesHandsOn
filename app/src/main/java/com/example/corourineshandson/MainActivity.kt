package com.example.corourineshandson

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.corourineshandson.ui_entities.Movie
import com.google.gson.Gson
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class MainActivity : AppCompatActivity() {

    lateinit var presenter: Presenter

    private lateinit var recyclerView: RecyclerView

    val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        showMovies(
            mutableListOf(
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo"),
                Movie(name = "demo")
            )
        )
        presenter = Presenter(this, FileLoader(this, Gson()), scope)

        presenter.start()
    }

    fun showMovies(movies: MutableList<Movie>) {
        recyclerView.adapter = MyAdapter(movies)
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}
