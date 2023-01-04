package com.example.movirapp.domain.useCases.movie.internet

import com.example.movirapp.domain.repositories.MovieRepository

class GetRecommendMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute(movieId: Int) = repository.getRecommendMovies(movieId)
}