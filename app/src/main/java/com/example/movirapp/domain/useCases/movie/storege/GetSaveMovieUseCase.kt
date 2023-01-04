package com.example.movirapp.domain.useCases.movie.storege

import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.repositories.MovieStorageRepository

class GetSaveMovieUseCase(private val repository: MovieStorageRepository) {
    suspend fun execute(movie: MovieDomain) = repository.saveMovie(movie)
}