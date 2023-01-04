package com.example.movirapp.data.network.servise

import com.example.movirapp.data.network.Utils
import com.example.movirapp.data.network.api.MovieApi
import com.example.movirapp.data.network.mappers.movie.MapMovieDetailsToDomain
import com.example.movirapp.data.network.mappers.movie.MapMoviesDataToDomain
import com.example.movirapp.domain.models.movie.MovieDetailsDomain

import com.example.movirapp.domain.models.movie.MoviesDomain
import com.example.movirapp.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    private val mapper = MapMoviesDataToDomain()
    private val mapDetails = MapMovieDetailsToDomain()

    override suspend fun getPopularMovies(page: Int): MoviesDomain {
        val response = api.getPopularMovies(Utils.API_KEY, "ru", page = page)
        return mapper.mapData(response)
    }

    override suspend fun getNowPlayMovies(page: Int): MoviesDomain {
        val response = api.getNowPlaying(Utils.API_KEY, "ru", page = page)
        return mapper.mapData(response)
    }

    override suspend fun getTopRatedMovies(page: Int): MoviesDomain {
        val response = api.getTopRatedMovies(Utils.API_KEY, "ru", page = page)
        return mapper.mapData(response)
    }

    override suspend fun getUpcomingMovies(page: Int): MoviesDomain {
        val response = api.getUpcomingMovies(Utils.API_KEY, "ru", page = page)
        return mapper.mapData(response)
    }

    override suspend fun getSearchMovies(query: String): MoviesDomain {
        val response = api.getSearchMovie(Utils.API_KEY, query, "en")
        return mapper.mapData(response)
    }

    override suspend fun getDetailsMovies(movieId: Int): MovieDetailsDomain {
        val response = api.getMovieDetails(movieId, Utils.API_KEY, "ru")
        return mapDetails.mapData(response)
    }

    override suspend fun getRecommendMovies(movieId: Int): MoviesDomain {
        val response = api.getRecommendMovies(movieId, Utils.API_KEY, "ru")
        return mapper.mapData(response)
    }

    override suspend fun getSimilarMovies(movieId: Int): MoviesDomain {
        val response = api.getSimilarMovies(movieId, Utils.API_KEY, "ru")
        return mapper.mapData(response)
    }
}


