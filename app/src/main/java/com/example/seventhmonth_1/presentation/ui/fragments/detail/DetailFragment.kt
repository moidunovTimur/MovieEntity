package com.example.seventhmonth_1.presentation.ui.fragments.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.seventhmonth_1.databinding.FragmentDetailBinding
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.presentation.ui.fragments.movies_list.MoviesFragment.Companion.KEY_MOVIE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@Suppress("DEPRECATION", "CAST_NEVER_SUCCEEDS")
@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel>()

    private lateinit var binding: FragmentDetailBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovie()
        initClickListeners()

    }

    private fun getMovie() {
        with(binding){
            val movie = (arguments?.getSerializable(KEY_MOVIE)) as Movie
            etName.setText(toString())
            etQuantity.setText(toString())
            etDate.setText(toString())
        }
    }

    private fun initClickListeners() {
        with(binding) {
            val movie = (arguments?.getSerializable(KEY_MOVIE)) as Movie
            btnUpdate.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.updateMovie(
                       Movie(
                            id = id,
                            name = binding.etName.text.toString(),
                            quantity = binding.etQuantity.text.toString(),
                            date = binding.etDate.text.toString()
                        )
                    )
                }
                findNavController().navigateUp()
            }
            btnDelete.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.deleteMovie(movie)
                }
                findNavController().navigateUp()
            }
        }
    }
}