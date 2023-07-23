package com.example.SeventhMonth_1.domain.usecases


import com.example.SeventhMonth_1.repositorie.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase  @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun update (movie: com.example.SeventhMonth_1.domain.models.Movie) {
        movieRepository.updateMovie(movie = movie)

    }
}
