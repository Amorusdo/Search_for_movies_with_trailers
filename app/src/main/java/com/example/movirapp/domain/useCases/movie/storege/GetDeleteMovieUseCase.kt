package com.example.movirapp.domain.useCases.movie.storege

import com.example.movirapp.domain.repositories.MovieStorageRepository

class GetDeleteMovieUseCase(private val repository: MovieStorageRepository) {
    suspend fun execute(movieId: Int) = repository.deleteMovie(movieId)
}