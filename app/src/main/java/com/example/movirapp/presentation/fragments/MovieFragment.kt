package com.example.movirapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movirapp.R
import com.example.movirapp.databinding.FragmentMovieBinding
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.presentation.activities.MovieDetailsActivity
import com.example.movirapp.presentation.adaptor.movie.MovieAdapter
import com.example.movirapp.presentation.viewModel.MovieType
import com.example.movirapp.presentation.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_search_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieFragment : Fragment(), MovieAdapter.RecyclerOnClickListener,
    AdapterView.OnItemSelectedListener {

    private val binding: FragmentMovieBinding by lazy {
        FragmentMovieBinding.inflate(layoutInflater)
    }
    private val rvAdapter: MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.PORTRAIT, this)
    }
    private val viewModel by viewModel<MoviesViewModel>()

    private lateinit var spinnerAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinner.onItemSelectedListener = this
        initSpinner()
        binding.rvMovie.adapter = rvAdapter
        observeViewModel()
        setupClickers()
    }

    private fun setupClickers() {
        binding.nextBtn.setOnClickListener { viewModel.nextPage() }
        binding.backBtn.setOnClickListener { viewModel.previousPage() }
        binding.button.setOnClickListener { viewModel.nextTenPage() }
    }

    private fun initSpinner() {
        binding.spinner.setPopupBackgroundResource(R.color.background)
        spinnerAdapter = ArrayAdapter(
            requireContext(), R.layout.spiner_color,
            listOf("Популярные", "На экранах", "Рейтинговые", "Ожидаемые")
        )
        spinnerAdapter.setDropDownViewResource(R.layout.spiner_color)
        binding.spinner.adapter = spinnerAdapter
    }

    private fun observeViewModel() {
        viewModel.movies.observe(viewLifecycleOwner) {
            rvAdapter.submitList(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            makeToast(it)
        }
        viewModel.page.observe(viewLifecycleOwner) {
            binding.pageNumber.text = it.toString()
        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(movie: MovieDomain) {
        startActivity(MovieDetailsActivity.launchMovieDetailsActivity(requireContext(), movie))
    }

    override fun onSaveClick(movie: MovieDomain) {
        viewModel.saveMovie(movie)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (position) {
            0 -> viewModel.getMovies(MovieType.POPULAR)
            1 -> viewModel.getMovies(MovieType.NOW_PLAYING)
            2 -> viewModel.getMovies(MovieType.TOP_RATED)
            3 -> viewModel.getMovies(MovieType.UPCOMING)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
