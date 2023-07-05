package com.example.seventhmonth_1.data.repositories

import com.example.seventhmonth_1.data.lokal.MovieDao
import com.example.seventhmonth_1.data.mappers.toEntity
import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
) : ContactRepository {
    override fun addMovie(movieEntity: MovieEntity): Flow<Resource<Unit>> {
        return flow {
         emit(Resource.Loading())
            try {
                val data = movieDao.addMovie(movieEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override fun getMovie(): Flow<Resource<List<MovieEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = movieDao.getMovie()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override fun getMovieByPerfomer(): Flow<Resource<List<MovieEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = movieDao.getMovieByPerfomer()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override fun getMovieByDuration(): Flow<Resource<List<MovieEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = movieDao.getMovieByDuration()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)


    }

    override fun updateMovie(movieEntity: MovieEntity): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = movieDao.updateMovie(movieEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)


    }

    override fun deleteMovie(movieEntity: MovieEntity): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = movieDao.deleteMovie(movieEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)

    }


}