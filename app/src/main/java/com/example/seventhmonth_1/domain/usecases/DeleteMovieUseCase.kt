package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.repositories.MovieRepository
import javax.inject.Inject

class DeleteMovieUseCase @Inject constructor (
    private val movieRepository: MovieRepository
) {
    fun delete(movie: Movie) {
       movieRepository.deleteMovie(movie = movie)

    }
}
