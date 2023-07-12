package com.example.seventhmonth_1.presentation.ui.Base

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.seventhmonth_1.presentation.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {

    protected fun <T> StateFlow<UiState<T>>.collectState(
        loadingState: (UiState<T>) -> Unit,
       onSuccess: (data:T) -> Unit
    ){
        viewLifecycleOwner.lifecycleScope.launch {
            this@collectState.collect {
                when (it) {
                    is UiState.EmptyState -> {

                    }

                    is UiState.Error -> {
                        Toast.makeText(
                            requireContext(),
                            "Error ${it.message}",
                            Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Loading -> {
                     loadingState.invoke(UiState.Loading())
                    }

                    is UiState.Success -> {
                     onSuccess.invoke(it.data)
                    }
                }
            }
        }
    }
}