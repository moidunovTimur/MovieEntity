package com.example.seventhmonth_1.data.lokal

import androidx.room.*
import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movieEntity: Movie)

    @Query("SELECT * FROM movies")
    suspend fun getMovie() : List<MovieEntity>

    @Query("SELECT * FROM movies ORDER BY perfomer ASC")
    suspend fun getMovieByPerfomer(): List<MovieEntity>

    @Query("SELECT * FROM movies ORDER BY CAST(duration " + "AS INTEGER)ASC")
    suspend fun getMovieByDuration(): List<MovieEntity>

    @Update
    suspend  fun updateMovie(movieEntity: Movie)

    @Delete
    suspend  fun deleteMovie(movieEntity: Movie)
}