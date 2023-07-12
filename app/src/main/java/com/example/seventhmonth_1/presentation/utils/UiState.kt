package com.example.seventhmonth_1.presentation.utils

 sealed class UiState <T> {

     class Loading<T> : UiState<T>()
     class Success<T>(val data:T) : UiState<T>()
     class Error<T>(val message:T) : UiState<T>()
     class EmptyState<T> : UiState<T>()
}