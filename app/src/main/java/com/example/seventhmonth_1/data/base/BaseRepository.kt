package com.example.seventhmonth_1.data.base

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T): Flow<Resource<T>> {

        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(request())
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown error")
                )
            }
        }

    }
}