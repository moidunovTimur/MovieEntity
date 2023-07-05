package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository
import javax.inject.Inject

class DeleteContactUseCase @Inject constructor (
    private val contactRepository: ContactRepository
) {
    fun deleteContact(contactEntity: MovieEntity) {
        contactRepository.addMovie(contactEntity)

    }
}
