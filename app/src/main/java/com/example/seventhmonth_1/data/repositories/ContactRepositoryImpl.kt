package com.example.seventhmonth_1.data.repositories

import com.example.seventhmonth_1.data.lokal.ContactDao
import com.example.seventhmonth_1.data.models.ContactEntity
import com.example.seventhmonth_1.domain.repositories.ContactRepository

class ContactRepositoryImpl(
    private val contactDao:ContactDao
) : ContactRepository {

    override fun addContact(contactEntity: ContactEntity) {
        contactDao.addContact(contactEntity)
    }

    override fun getContact(): List<ContactEntity> {
     return contactDao.getContact()
    }

    override fun updateContact(contactEntity: ContactEntity) {
          contactDao.updateContact(contactEntity)
    }

    override fun deleteContact(contactEntity: ContactEntity) {
           contactDao.deleteContact(contactEntity)
    }
}