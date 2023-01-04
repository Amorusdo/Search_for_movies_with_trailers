package com.example.movirapp.data.storrage.servise

import android.app.Application
import com.example.movirapp.data.storrage.mapper.MapMovieToStorage
import com.example.movirapp.data.storrage.mapper.MapMoviesListToDomain
import com.example.movirapp.data.storrage.room.Database
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.repositories.MovieStorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieStorageRepositoryImpl(private val application: Application) : MovieStorageRepository {

    private val dao = Database.getInstance(application).movieDao()
    private val mapper = MapMovieToStorage()
    private val mapList = MapMoviesListToDomain()

    override suspend fun saveMovie(movie: MovieDomain) {
        withContext(Dispatchers.IO) {
            dao.saveMovie(mapper.mapDomain(movie))
        }
    }

    override suspend fun deleteMovie(movieInt: Int) {
        withContext(Dispatchers.IO) {
            dao.deleteMoviesFromStorage(movieInt)
        }
    }

    override suspend fun getStorageMovie(): List<MovieDomain> {
        return withContext(Dispatchers.IO) {
            mapList.mapData(
                dao.getStorageMovies()
            )
        }
    }
}