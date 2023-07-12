package com.example.seventhmonth_1.presentation.ui.fragments.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.domain.usecases.AddMovieUseCase
import com.example.seventhmonth_1.domain.usecases.GetMoviesUseCase
import com.example.seventhmonth_1.domain.utils.Resource
import com.example.seventhmonth_1.presentation.Base.BaseViewModel
import com.example.seventhmonth_1.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addMoviesUseCase: AddMovieUseCase
    ) :BaseViewModel() {

    private val getAllMoviesState = MutableStateFlow<UiState<List<Movie>>>(UiState.EmptyState())
    val getAllMovieState = getAllMoviesState.asStateFlow()

    fun addAllMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            addMoviesUseCase.execute(movie = movie)
        }
    }

    fun getAllMovie() {
        getMoviesUseCase.getMovie().collectData(getAllMoviesState)
    }
}