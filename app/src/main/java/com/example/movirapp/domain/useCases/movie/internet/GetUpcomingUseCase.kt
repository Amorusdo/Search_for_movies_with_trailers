package com.example.movirapp.domain.useCases.movie.internet

import com.example.movirapp.domain.repositories.MovieRepository

class GetUpcomingUseCase(private val repository: MovieRepository) {
    suspend fun execute(page: Int) = repository.getUpcomingMovies(page)
}