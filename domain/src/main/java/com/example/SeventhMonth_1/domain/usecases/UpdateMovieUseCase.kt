package com.example.SeventhMonth_1.domain.usecases


import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.repositorie.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase  @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun update (movie:Movie) {
        movieRepository.updateMovie(movie = movie)

    }
}
