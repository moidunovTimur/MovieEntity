package com.example.seventhmonth_1.presentation.ui.Base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seventhmonth_1.domain.utils.Resource
import com.example.seventhmonth_1.presentation.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        state: MutableStateFlow<UiState<T>>
    ){
        viewModelScope.launch {
            this@collectData.collect{ resource ->
                when(resource) {
                    is Resource.Loading -> {
                        state.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        if (resource.data!= null)
                            state.value = UiState.Success(resource.data)
                    }

                    is Resource.Error -> {
                        state.value = UiState.Error(resource.message?:"Error")
                    }
                }
            }
        }
    }
}