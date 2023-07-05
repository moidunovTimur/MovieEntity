package com.example.seventhmonth_1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
data class MovieEntity (
        @PrimaryKey(autoGenerate = true)
        val quality: Int,
        val name: String,
        val quantity:Int,
        val date: String,
        )
