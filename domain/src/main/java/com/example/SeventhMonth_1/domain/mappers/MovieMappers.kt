package com.example.SeventhMonth_1.domain.mappers

import com.example.SeventhMonth_1.data.models.MovieEntity
import com.example.SeventhMonth_1.domain.models.Movie


fun MovieEntity.toLIst() = Movie(id =id, name = toString(), quantity = toString(), date = toString())

fun Movie.toMovie() = MovieEntity(id = id, name = toString(), quantity = toString(), date = toString())