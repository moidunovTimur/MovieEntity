package com.example.seventhmonth_1.domain.repositories

import com.example.seventhmonth_1.data.models.ContactEntity

interface ContactRepository {


     fun addContact(contactEntity: ContactEntity)

     fun getContact() : List<ContactEntity>

     fun updateContact(contactEntity: ContactEntity)

     fun deleteContact(contactEntity: ContactEntity)
}