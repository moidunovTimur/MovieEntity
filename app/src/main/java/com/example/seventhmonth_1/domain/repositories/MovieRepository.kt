package com.example.seventhmonth_1.domain.repositories

import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

      fun addMovie(movie: Movie): Flow<Resource<Unit>>

      fun getMovie(): Flow<Resource<List<Movie>>>

      fun getMovieByPerfomer(): Flow<Resource<List<Movie>>>

      fun getMovieByDuration(): Flow<Resource<List<Movie>>>

      fun updateMovie(movie: Movie):Flow<Resource<Unit>>

      fun deleteMovie(movie: Movie):Flow<Resource<Unit>>
}