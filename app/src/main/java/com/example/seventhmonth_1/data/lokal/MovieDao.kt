package com.example.seventhmonth_1.data.lokal

import androidx.room.*
import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies")
     fun getMovie() : List<Movie>

    @Query("SELECT * FROM movies ORDER BY perfomer ASC")
     fun getMovieByPerfomer(): List<Movie>

    @Query("SELECT * FROM movies ORDER BY CAST(duration " + "AS INTEGER)ASC")
     fun getMovieByDuration(): List<Movie>

    @Update
    fun updateMovie(movieEntity: MovieEntity)

    @Delete
     fun deleteMovie(movieEntity: MovieEntity)
}