package com.example.movirapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.useCases.movie.storege.GetDeleteMovieUseCase
import com.example.movirapp.domain.useCases.movie.storege.GetStorageMoviesUseCase
import kotlinx.coroutines.launch

class StorageMoviesViewModel(
    private val deleteMoviesUseCase: GetDeleteMovieUseCase,
    private val getStorageMoviesUseCase: GetStorageMoviesUseCase
) : ViewModel() {

    private val _movies: MutableLiveData<List<MovieDomain>> = MutableLiveData()
    val movies: LiveData<List<MovieDomain>> get() = _movies

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    fun getStorageMovies() = viewModelScope.launch {
        kotlin.runCatching {
            getStorageMoviesUseCase.execute()
        }
            .onSuccess {
                _movies.value = it
            }
            .onFailure {
                _error.value = it.message
            }
    }

    fun deleteMovies(movieId: Int) = viewModelScope.launch {
        kotlin.runCatching {
            deleteMoviesUseCase.execute(movieId)
        }
    }
}