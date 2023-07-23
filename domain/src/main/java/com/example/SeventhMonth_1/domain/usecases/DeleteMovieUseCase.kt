package com.example.SeventhMonth_1.domain.usecases

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.repositorie.MovieRepository
import javax.inject.Inject

class DeleteMovieUseCase @Inject constructor (
    private val movieRepository: MovieRepository
) {
    fun delete(movie: Movie) {
        movieRepository.deleteMovie(movie = movie)

    }
}
