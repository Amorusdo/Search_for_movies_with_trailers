package com.example.movirapp.presentation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.useCases.movie.internet.GetNowPlayMoviesUseCase
import com.example.movirapp.domain.useCases.movie.internet.GetPopularMoviesUseCase
import com.example.movirapp.domain.useCases.movie.internet.GetTopRatedMoviesUseCase
import com.example.movirapp.domain.useCases.movie.internet.GetUpcomingUseCase
import com.example.movirapp.domain.useCases.movie.storege.GetSaveMovieUseCase

import kotlinx.coroutines.launch

enum class MovieType {
    POPULAR,
    NOW_PLAYING,
    TOP_RATED,
    UPCOMING
}

class MoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayMoviesUseCase: GetNowPlayMoviesUseCase,
    private val getUpcomingUseCase: GetUpcomingUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getSaveMovieUseCase: GetSaveMovieUseCase
) : ViewModel() {

    private val _movies: MutableLiveData<List<MovieDomain>> = MutableLiveData()
    val movies: MutableLiveData<List<MovieDomain>> get() = _movies

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private var _latestPosition: MovieType = MovieType.POPULAR

    private val _page: MutableLiveData<Int> = MutableLiveData(1)
    val page: LiveData<Int> get() = _page

    private var totalPage: Int? = null

    init {
        getMovies(MovieType.POPULAR)
    }

    fun getMovies(type: MovieType) {
        if (type != _latestPosition) {
            _latestPosition = type
            _page.value = 1
        }
        when (type) {
            MovieType.NOW_PLAYING -> getNowPlayMovies(_page.value!!)
            MovieType.POPULAR -> getPopularMovies(_page.value!!)
            MovieType.TOP_RATED -> getTopRatedMovies(_page.value!!)
            MovieType.UPCOMING -> getUpComingMovies(_page.value!!)
        }
    }

    private fun getPopularMovies(page: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getPopularMoviesUseCase.execute(page)
        }.onSuccess {
            movies.value = it.movies
            totalPage = it.totalPages
        }
            .onFailure { _error.value = it.message }
    }

    private fun getNowPlayMovies(page: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getNowPlayMoviesUseCase.execute(page)
        }
            .onSuccess {
                _movies.value = it.movies
                totalPage = it.totalPages
            }
            .onFailure {
                _error.value = it.message
            }
    }

    private fun getTopRatedMovies(page: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getTopRatedMoviesUseCase.execute(page)
        }
            .onSuccess {
                _movies.value = it.movies
                totalPage = it.totalPages
            }
            .onFailure {
                _error.value = it.message
            }
    }

    private fun getUpComingMovies(page: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getUpcomingUseCase.execute(page)
        }
            .onSuccess {
                _movies.value = it.movies
                totalPage = it.totalPages
            }
            .onFailure {
                _error.value = it.message

            }
    }

    fun nextPage() {
        if (_page.value!! < totalPage!!) {
            _page.value = _page.value!! + 1
        }
        getMovies(_latestPosition)
    }

    fun nextTenPage() {
        if (_page.value!! < totalPage!!) {
            _page.value = _page.value!! + 10
        }
        getMovies(_latestPosition)
    }

    fun previousPage() {
        if (_page.value!! > 1) {
            _page.value = _page.value!! - 1
            getMovies(_latestPosition)
        }

    }

    fun saveMovie(movieDomain: MovieDomain) = viewModelScope.launch {
        getSaveMovieUseCase.execute(movieDomain)
    }
}