package com.example.movirapp.domain.repositories

import com.example.movirapp.domain.models.movie.MovieDomain

interface MovieStorageRepository {
    suspend fun saveMovie(movie: MovieDomain)
    suspend fun deleteMovie(movieInt: Int)
    suspend fun getStorageMovie():List<MovieDomain>
}