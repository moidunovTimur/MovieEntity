package com.example.seventhmonth_1.presentation.ui.fragments.movies_list

import androidx.lifecycle.viewModelScope
import com.example.SeventhMonth_1.domain.models.Movie
import com.example.SeventhMonth_1.domain.usecases.AddMovieUseCase
import com.example.SeventhMonth_1.domain.usecases.GetMovieByPerfumerUseCase
import com.example.SeventhMonth_1.domain.usecases.GetMovieUseCase
import com.example.SeventhMonth_1.domain.usecases.GteMovieByDurationUseCase
import com.example.seventhmonth_1.presentation.ui.Base.BaseViewModel
import com.example.seventhmonth_1.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(

    private val getMovieUseCase: GetMovieUseCase,
    private val addMovieUseCase: AddMovieUseCase,
    private val getMovieByPerfumerUseCase: GetMovieByPerfumerUseCase,
    private val getMovieByDurationUseCase: GteMovieByDurationUseCase
    ) : BaseViewModel() {

    private val getAllMoviesState = MutableStateFlow<UiState<List<Movie>>>(
        UiState.EmptyState())
    val getAllMovieState = getAllMoviesState.asStateFlow()

    fun addAllMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            addMovieUseCase.add(movie = movie)
        }
    }

    fun getAllMovie() {
        getMovieUseCase.getMovie().collectData(getAllMoviesState)
    }

    fun getMovieByPerf(){
        getMovieByPerfumerUseCase.getMoviePerf().collectData(getAllMoviesState)
    }

    fun getMovieDuration(){
        getMovieByDurationUseCase.getMovDuration().collectData(getAllMoviesState)
    }
}