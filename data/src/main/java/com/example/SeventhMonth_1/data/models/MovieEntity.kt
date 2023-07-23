package com.example.SeventhMonth_1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.SeventhMonth_1.data.models.MovieEntity.Companion.MOVIE_DISK


@Entity(tableName = MOVIE_DISK)
data class MovieEntity(


    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val quantity: String,
    val date: String,
) {
    companion object {
        const val MOVIE_DISK = "movie_disk"
    }
}
