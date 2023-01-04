package com.example.movirapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movirapp.databinding.FragmentSavedMovieBinding
import com.example.movirapp.domain.models.movie.MovieDetailsDomain
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.presentation.activities.MovieDetailsActivity
import com.example.movirapp.presentation.adaptor.movie.MovieAdapter
import com.example.movirapp.presentation.viewModel.StorageMoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SavedMovieFragment : Fragment(), MovieAdapter.RecyclerOnClickListener {

    private val binding: FragmentSavedMovieBinding by lazy {
        FragmentSavedMovieBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<StorageMoviesViewModel>()

    private val adapter: MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.PORTRAIT, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMovie.adapter = adapter
    }

    override fun onItemClick(movie: MovieDomain) {
       startActivity(MovieDetailsActivity.launchMovieDetailsActivity(requireContext(),movie))
    }

    override fun onSaveClick(movie: MovieDomain) {
        viewModel.deleteMovies(movie.movieId)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getStorageMovies()
        viewModel.movies.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    override fun onPause() {
        super.onPause()
    }
}