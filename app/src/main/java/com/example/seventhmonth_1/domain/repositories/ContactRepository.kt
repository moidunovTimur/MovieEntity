package com.example.seventhmonth_1.domain.repositories

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {


     fun addMovie(movieEntity: MovieEntity): Flow<Resource<Unit>>

     fun getMovie(): Flow<Resource<List<MovieEntity>>>

     fun getMovieByPerfomer(): Flow<Resource<List<MovieEntity>>>

     fun getMovieByDuration(): Flow<Resource<List<MovieEntity>>>

     fun updateMovie(contactEntity: MovieEntity): Flow<Resource<Unit>>

     fun deleteMovie(contactEntity: MovieEntity): Flow<Resource<Unit>>
}