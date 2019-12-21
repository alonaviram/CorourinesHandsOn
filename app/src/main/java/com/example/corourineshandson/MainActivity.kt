package com.example.corourineshandson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this, FileLoader(this, Gson()))
        presenter.start()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}
