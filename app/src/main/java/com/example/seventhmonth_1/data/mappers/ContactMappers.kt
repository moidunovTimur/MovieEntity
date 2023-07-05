package com.example.seventhmonth_1.data.mappers

import com.example.seventhmonth_1.data.models.MovieEntity
import com.example.seventhmonth_1.domain.models.Movie

fun MovieEntity.toEntity() = Movie(quality,name,quantity,date)

fun Movie.toContact() = MovieEntity(quality, name, quantity ,date)

