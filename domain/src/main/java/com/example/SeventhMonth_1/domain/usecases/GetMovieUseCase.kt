package com.example.SeventhMonth_1.domain.usecases

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.utils.Resource
import com.example.SeventhMonth_1.repositorie.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieUseCase  @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun getMovie() : Flow<Resource<List<Movie>>> {
        return movieRepository.getMovie()
    }
}
