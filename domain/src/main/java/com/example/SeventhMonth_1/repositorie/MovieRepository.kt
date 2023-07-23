package com.example.SeventhMonth_1.repositorie

import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun addMovie(movie: android.graphics.Movie): Flow<Resource<Unit>>

    fun getMovie(): Flow<Resource<List<Movie>>>

    fun getMovieByPerfomer(): Flow<Resource<List<Movie>>>

    fun getMovieByDuration(): Flow<Resource<List<Movie>>>

    fun updateMovie(movie: android.graphics.Movie): Flow<Resource<Unit>>

    fun deleteMovie(movie: Movie): Flow<Resource<Unit>>
    fun addMovie(movie: Movie): Flow<Resource<Unit>>
    fun updateMovie(movie: Movie): Flow<Resource<Unit>>
}
