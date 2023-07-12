package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.repositories.MovieRepository
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun execute (movie: Movie) {
        movieRepository.addMovie(movie = movie)
    }
}