package com.example.seventhmonth_1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.Inet4Address


@Entity(tableName = "contacts")
data class ContactEntity (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val number: Int,
        val address: String,
        )
