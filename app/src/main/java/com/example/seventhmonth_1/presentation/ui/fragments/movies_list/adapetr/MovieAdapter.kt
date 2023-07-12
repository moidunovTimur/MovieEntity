package com.example.seventhmonth_1.presentation.ui.fragments.movies_list.adapetr

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.databinding.ItemMovieBinding
import com.example.seventhmonth_1.domain.models.Movie
import kotlin.reflect.KFunction1

class MovieAdapter(
    private val onClick: (movie : Movie) -> Unit
) : Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addTasks(movie: List<Movie>) {
        movieList.clear()
        movieList.addAll(movie)
        notifyDataSetChanged()
    }

    fun getMovie(position : Int): Movie {
        return movieList [position]
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movie = movieList[position])
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
       RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: Movie) {
            with(binding){
                tvName.text = movie.name
                tvQuantity.text = movie.quantity
                tvDate.text = movie.date
            }
            itemView.setOnClickListener {
                onClick(getMovie(adapterPosition))
            }
        }
    }
}



