package com.example.SeventhMonth_1.data.lokal

import android.graphics.Movie
import androidx.room.*
import com.example.SeventhMonth_1.data.models.MovieEntity


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies")
    fun getMovie() : List<Movie>

    @Query("SELECT * FROM movies ORDER BY perfomer ASC")
    fun getMovieByPerfumer(): List<Movie>

    @Query("SELECT * FROM movies ORDER BY CAST(duration " + "AS INTEGER)ASC")
    fun getMovieByDuration(): List<Movie>

    @Update
    fun updateMovie(movieEntity: MovieEntity)

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)

}