package com.example.movirapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.movirapp.databinding.FragmentSearchMovieBinding
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.presentation.activities.MovieDetailsActivity
import com.example.movirapp.presentation.adaptor.movie.MovieAdapter
import com.example.movirapp.presentation.viewModel.SearchMovieVieModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchMovieFragment : Fragment() , MovieAdapter.RecyclerOnClickListener{

    private val binding: FragmentSearchMovieBinding by lazy {
        FragmentSearchMovieBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModel<SearchMovieVieModel>()


    private val movieAdapter : MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.PORTRAIT,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.movies.observe(viewLifecycleOwner){
        movieAdapter.submitList(it.movies)
            binding.rvSerch.adapter = movieAdapter
        }
    }

    private fun search (){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
             return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                viewModel.searchMovie(query)
                return false
            }
        })
        binding.searchView.setOnCloseListener { false }
    }

    override fun onItemClick(movie: MovieDomain) {
        startActivity(MovieDetailsActivity.launchMovieDetailsActivity(requireContext(), movie))
    }

    override fun onSaveClick(movie: MovieDomain) {
        TODO("Not yet implemented")
    }
}

