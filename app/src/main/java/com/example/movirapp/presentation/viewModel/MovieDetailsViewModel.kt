package com.example.movirapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movirapp.domain.models.movie.MovieDetailsDomain
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.domain.models.video.Trailer
import com.example.movirapp.domain.useCases.movie.internet.GetMovieDetailsUseCase
import com.example.movirapp.domain.useCases.movie.internet.GetRecommendMoviesUseCase
import com.example.movirapp.domain.useCases.movie.internet.GetSimilarMoviesUseCase
import com.example.movirapp.domain.useCases.movie.storege.GetSaveMovieUseCase
import com.example.movirapp.domain.useCases.person.GetPersonDetailsUseCase
import com.example.movirapp.domain.useCases.video.GetTrailerUseCase
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getGetPersonUseCase: GetPersonDetailsUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getRecommendMoviesUseCase: GetRecommendMoviesUseCase,
    private val getSaveMovieUseCase: GetSaveMovieUseCase,
    private val getTrailerUseCase: GetTrailerUseCase

) : ViewModel() {

    private val _similarMovies: MutableLiveData<List<MovieDomain>> = MutableLiveData()
    val similarMovies: LiveData<List<MovieDomain>> get() = _similarMovies

    private val _recommendMovies: MutableLiveData<List<MovieDomain>> = MutableLiveData()
    val recommendMovies: LiveData<List<MovieDomain>> get() = _recommendMovies

    private val _movie: MutableLiveData<MovieDetailsDomain> = MutableLiveData()
    val movie: MutableLiveData<MovieDetailsDomain> get() = _movie

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private val _persons: MutableLiveData<List<PersonDetailsDomain>> = MutableLiveData()
    val person: LiveData<List<PersonDetailsDomain>> get() = _persons

    private val _trailer: MutableLiveData<Trailer> = MutableLiveData()
    val trailer: LiveData<Trailer> get() = _trailer


    fun getTrailer(movieId: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getTrailerUseCase.execute(movieId)
        }
            .onSuccess {
                _trailer.value = it
            }
            .onFailure {
                _error.value = it.message
            }
    }

    fun getMovieDetails(movieId: Int) = viewModelScope.launch {
        kotlin.runCatching {
            getMovieDetailsUseCase.execute(movieId)
        }
            .onSuccess {
                _movie.value = it

            }
            .onFailure {
                _error.value = it.message
            }
    }

    fun getPersons(personsId: List<Int>) = viewModelScope.launch {
        val personsList = mutableListOf<PersonDetailsDomain>()
        if (personsId.isNotEmpty()) {
            for (i in personsId.indices) {
                kotlin.runCatching {
                    getGetPersonUseCase.execute(personsId[i])
                }
                    .onSuccess {
                        personsList.add(it)
                    }
                    .onFailure {
                        _error.value = it.message
                    }
            }
            if (personsList.isNotEmpty()) {
                _persons.value = personsList
            }
        }
    }

    fun getSimilarMovies(movieId: Int) = viewModelScope.launch {
        kotlin.runCatching { getSimilarMoviesUseCase.execute(movieId) }
            .onSuccess { _similarMovies.value = it.movies }
            .onFailure { _error.value = it.message }
    }

    fun getRecommendMovies(movieId: Int) = viewModelScope.launch {
        kotlin.runCatching { getRecommendMoviesUseCase.execute(movieId) }
            .onSuccess { _recommendMovies.value = it.movies }
            .onFailure { _error.value = it.message }
    }
}