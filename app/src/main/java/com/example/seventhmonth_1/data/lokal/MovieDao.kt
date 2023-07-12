package com.example.seventhmonth_1.data.lokal

import androidx.room.*
import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies")
    suspend fun getMovie() : List<Movie>

    @Query("SELECT * FROM movies ORDER BY perfomer ASC")
    suspend fun getMovieByPerfomer(): List<Movie>

    @Query("SELECT * FROM movies ORDER BY CAST(duration " + "AS INTEGER)ASC")
    suspend fun getMovieByDuration(): List<Movie>

    @Update
    suspend  fun updateMovie(movieEntity: MovieEntity)

    @Delete
    suspend  fun deleteMovie(movieEntity: MovieEntity)
}