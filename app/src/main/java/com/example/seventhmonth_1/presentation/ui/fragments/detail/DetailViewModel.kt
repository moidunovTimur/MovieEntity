package com.example.seventhmonth_1.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.usecases.DeleteMovieUseCase
import com.example.seventhmonth_1.domain.usecases.UpdateMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateMovieUseCase: UpdateMovieUseCase,
    private val deleteMovieUseCase: DeleteMovieUseCase
) : ViewModel() {

     fun updateMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            updateMovieUseCase.update(movie = movie)
        }
    }

      fun deleteMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMovieUseCase.delete(movie = movie)
        }
    }
}

