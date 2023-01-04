package com.example.movirapp.domain.useCases.movie.internet

import com.example.movirapp.domain.repositories.MovieRepository

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute(page: Int) = repository.getPopularMovies(page)
}