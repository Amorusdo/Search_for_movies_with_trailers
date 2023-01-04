package com.example.movirapp.domain.useCases.movie.internet

import com.example.movirapp.domain.repositories.MovieRepository

class GetSearchMovieUseCase(private val repository: MovieRepository) {
    suspend fun execute(query: String) =
        repository.getSearchMovies( query)
}