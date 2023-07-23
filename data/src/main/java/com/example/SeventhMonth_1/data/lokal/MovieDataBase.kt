package com.example.SeventhMonth_1.data.lokal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.SeventhMonth_1.data.models.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun MovieDao(): MovieDao

}