package com.example.SeventhMonth_1.domain.usecases

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.repositorie.MovieRepository
import com.example.SeventhMonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieByPerfumerUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun getMoviePerf() : Flow<Resource<List<Movie>>> {
        return movieRepository.getMovieByPerfumer()
    }
}
