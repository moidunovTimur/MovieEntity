package com.example.seventhmonth_1.data.repositories

import com.example.seventhmonth_1.data.base.BaseRepository
import com.example.seventhmonth_1.data.lokal.MovieDao
import com.example.seventhmonth_1.data.mappers.toMovie
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.repositories.MovieRepository
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow



import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
) : BaseRepository(), MovieRepository {

    override fun addMovie(movie: Movie) : Flow<Resource<Unit>> = doRequest{
        movieDao.addMovie(movie.toMovie())

    }

    override fun getMovie(): Flow<Resource<List<Movie>>> = doRequest {
          movieDao.getMovie().toList()
    }
    override fun getMovieByPerfomer(): Flow<Resource<List<Movie>>> = doRequest {
        movieDao.getMovie().toList()

    }

    override fun getMovieByDuration(): Flow<Resource<List<Movie>>> = doRequest {
        movieDao.getMovie().toList()


    }

    override  fun updateMovie(movie: Movie) : Flow<Resource<Unit>> = doRequest {
        movieDao.updateMovie(movie.toMovie())

    }

    override  fun deleteMovie(movie: Movie) : Flow<Resource<Unit>> = doRequest {
        movieDao.deleteMovie(movie.toMovie())
    }




}