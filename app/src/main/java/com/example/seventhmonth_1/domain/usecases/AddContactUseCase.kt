package com.example.seventhmonth_1.domain.usecases

import com.example.seventhmonth_1.data.models.ContactEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository

class AddContactUseCase(
    private val contactRepository: ContactRepository
) {
    fun addContact(contactEntity: ContactEntity){
        contactRepository.addContact(contactEntity)
    }
}