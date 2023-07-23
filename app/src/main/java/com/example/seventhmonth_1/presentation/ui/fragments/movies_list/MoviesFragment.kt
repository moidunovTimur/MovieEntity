package com.example.seventhmonth_1.presentation.ui.fragments.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.seventhmonth_1.R
import com.example.seventhmonth_1.databinding.FragmentMoviesBinding
import com.example.seventhmonth_1.domain.models.Movie
import com.example.seventhmonth_1.presentation.ui.Base.BaseFragment
import com.example.seventhmonth_1.presentation.ui.fragments.movies_list.adapetr.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val adapter = MovieAdapter(onClick = ::onClick)
    private val viewModel by viewModels<MovieViewModel>()


    private fun onClick(movie: Movie) {
        findNavController().navigate(
            R.id.detailFragment, bundleOf (KEY_MOVIE to movie)

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentMoviesBinding.inflate(inflater,container,false)
      return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnClickListeners()

    }

    private fun initOnClickListeners() {
        with(binding) {
            btnSave.setOnClickListener {
                viewModel.addAllMovie(
                   Movie(
                        id = (0..9999).random(),
                        name = etdName.text.toString(),
                        quantity = etdQuantity.text.toString(),
                        date = etdDate.text.toString()
                    )
                )
            }
        }

            viewModel.getAllMovie()
          viewModel.getAllMovieState.collectState(
             loadingState =  {
             binding.progressbar.visibility = View.VISIBLE

              },
             onSuccess =  { listOfMovie ->
             binding.progressbar.visibility = View.GONE
              adapter.notifyDataSetChanged()
                 binding.rvMovie.adapter = adapter
                 println("SUCCESS_STATE->${listOfMovie.size}")

             }
          )
    }

    companion object {
        const val KEY_MOVIE = "keyMovieId"
    }
}