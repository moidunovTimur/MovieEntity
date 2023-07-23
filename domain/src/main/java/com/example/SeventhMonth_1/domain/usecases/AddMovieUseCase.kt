package com.example.SeventhMonth_1.domain.usecases

import com.example.SeventhMonth_1.repositorie.MovieRepository
import javax.inject.Inject

class AddMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun execute (movie: android.graphics.Movie) {
        movieRepository.addMovie(movie = movie)
    }
}
