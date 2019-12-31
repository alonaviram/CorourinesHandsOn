package com.example.corourineshandson

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.corourineshandson.ui_entities.Movie

class MyAdapter(
    private val movies: MutableList<Movie>
) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = "title: ${movies[position].name}"
        holder.generesTextView.text = "genres: ${movies[position].genres}"
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val generesTextView = view.findViewById<TextView>(R.id.generes_text_view)!!
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)!!
}
