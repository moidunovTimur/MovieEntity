package com.example.SeventhMonth_1.domain.repositorie

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {



    fun getMovie(): Flow<Resource<List<Movie>>>

    fun getMovieByPerfumer(): Flow<Resource<List<Movie>>>

    fun getMovieByDuration(): Flow<Resource<List<Movie>>>

    fun deleteMovie(movie: Movie): Flow<Resource<Unit>>

    fun addMovie(movie: Movie): Flow<Resource<Unit>>

    fun updateMovie(movie: Movie): Flow<Resource<Unit>>
}
