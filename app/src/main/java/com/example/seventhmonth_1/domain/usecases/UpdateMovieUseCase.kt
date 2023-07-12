package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.repositories.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
        ) {
    fun update (movie: Movie) {
        movieRepository.updateMovie(movie = movie)

    }
}
