package com.example.submissioncapstoneproject.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissioncapstoneproject.core.R
import com.example.submissioncapstoneproject.core.databinding.ItemRowMovieBinding
import com.example.submissioncapstoneproject.core.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListMovieViewHolder>(){

    private var listMovie = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListMovie: List<Movie>?) {
        if (newListMovie == null) return
        listMovie.clear()
        listMovie.addAll(newListMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListMovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false))


    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        val data = listMovie[position]
        holder.bind(data)
    }

   inner class ListMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val binding = ItemRowMovieBinding.bind(itemView)
       fun bind(data: Movie) {
           with(binding) {
               Glide.with(itemView.context)
                   .load("https://image.tmdb.org/t/p/original${data.poster}")
                   .into(imgPoster)
               tvTitle.text = data.title
               tvDate.text = data.date
               tvRating.text = data.rating.toString()
           }
       }

       init {
           binding.root.setOnClickListener {
               onItemClick?.invoke(listMovie[bindingAdapterPosition])
           }
       }
   }



}