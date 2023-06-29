package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.ContactEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository

class GetContactsUseCase(
    private val contactRepository: ContactRepository
) {

    fun getAllContact() : List<ContactEntity> {
        return contactRepository.getContact()
    }
}