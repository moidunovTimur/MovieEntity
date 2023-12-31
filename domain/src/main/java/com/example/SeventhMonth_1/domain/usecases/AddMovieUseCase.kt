package com.example.SeventhMonth_1.domain.usecases

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.repositorie.MovieRepository
import javax.inject.Inject

class AddMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun add (movie:Movie) {
        movieRepository.addMovie(movie = movie)
    }
}
