package com.example.SeventhMonth_1.data.repositories

import com.example.SeventhMonth_1.data.base.BaseRepository
import com.example.SeventhMonth_1.data.lokal.MovieDao
import com.example.SeventhMonth_1.domain.mappers.toMovie
import com.example.SeventhMonth_1.domain.utils.Resource
import com.example.SeventhMonth_1.domain.repositorie.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl (
    private val movieDao: MovieDao
) : BaseRepository(), MovieRepository {


    override fun addMovie(movie: com.example.SeventhMonth_1.domain.models.Movie): Flow<Resource<Unit>> = doRequest {
        movieDao.addMovie(movie.toMovie())
    }

    override fun getMovie(): Flow<Resource<List<com.example.SeventhMonth_1.domain.models.Movie>>> = doRequest {
        movieDao.getMovie().toList()
    }

    override fun getMovieByPerfumer(): Flow<Resource<List<com.example.SeventhMonth_1.domain.models.Movie>>> = doRequest {
        movieDao.getMovieByPerfumer().toList()
    }

    override fun getMovieByDuration(): Flow<Resource<List<com.example.SeventhMonth_1.domain.models.Movie>>> = doRequest {
        movieDao.getMovieByDuration().toList()
    }



    override fun updateMovie(movie: com.example.SeventhMonth_1.domain.models.Movie): Flow<Resource<Unit>> = doRequest {
       movieDao.updateMovie(movie.toMovie())
    }

    override fun deleteMovie(movie: com.example.SeventhMonth_1.domain.models.Movie): Flow<Resource<Unit>> = doRequest {
        movieDao.deleteMovie(movie.toMovie())
    }


}

