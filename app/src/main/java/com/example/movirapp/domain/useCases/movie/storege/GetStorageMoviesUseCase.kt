package com.example.movirapp.domain.useCases.movie.storege

import com.example.movirapp.domain.repositories.MovieStorageRepository

class GetStorageMoviesUseCase(private val repository: MovieStorageRepository) {
    suspend fun execute() = repository.getStorageMovie()
}