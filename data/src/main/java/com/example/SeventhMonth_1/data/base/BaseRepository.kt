package com.example.SeventhMonth_1.data.base

import com.example.SeventhMonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(request: () -> Unit): Flow<Resource<T>> {

        return flow {
            emit (Resource.Loading())
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
