package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository
import com.example.seventhmonth_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
    private val contactRepository: ContactRepository
) {

    fun getAllContact() : Flow<Resource<List<MovieEntity>>> {
        return contactRepository.getMovie()
    }
}