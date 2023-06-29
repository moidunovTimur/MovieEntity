package com.example.seventhmonth_1.data.lokal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.seventhmonth_1.data.models.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun ContactDao(): ContactDao
}