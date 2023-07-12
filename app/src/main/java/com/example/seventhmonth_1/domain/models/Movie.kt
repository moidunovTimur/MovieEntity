package com.example.seventhmonth_1.domain.models

import java.io.Serializable

data class Movie(
    val id: Int,
    val name: String,
    val quantity: String,
    val date: String,
) : Serializable
