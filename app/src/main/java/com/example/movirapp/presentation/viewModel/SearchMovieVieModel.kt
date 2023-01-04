package com.example.movirapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movirapp.domain.models.movie.MoviesDomain
import com.example.movirapp.domain.useCases.movie.internet.GetSearchMovieUseCase
import kotlinx.coroutines.launch

class SearchMovieVieModel(

    private val searchMovieUseCase: GetSearchMovieUseCase,
) : ViewModel() {

    private val _movies: MutableLiveData<MoviesDomain> = MutableLiveData()
    val movies: LiveData<MoviesDomain> get() = _movies

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error



    fun searchMovie(query: String) = viewModelScope.launch {
        kotlin.runCatching {
            searchMovieUseCase.execute(query)
        }
            .onSuccess {
                _movies.value = it
            }
            .onFailure {
                _error.value = it.message
            }
    }
}