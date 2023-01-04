package com.example.movirapp.domain.repositories


import com.example.movirapp.domain.models.movie.MovieDetailsDomain
import com.example.movirapp.domain.models.movie.MoviesDomain
import org.intellij.lang.annotations.Language

interface MovieRepository {
    suspend fun getPopularMovies(page:Int) : MoviesDomain
    suspend fun getNowPlayMovies(page: Int) : MoviesDomain
    suspend fun getTopRatedMovies(page: Int): MoviesDomain
    suspend fun getUpcomingMovies(page: Int): MoviesDomain
    suspend fun getSearchMovies(query: String) : MoviesDomain
    suspend fun getDetailsMovies(movieId:Int): MovieDetailsDomain

    suspend fun getRecommendMovies(movieId: Int): MoviesDomain
    suspend fun getSimilarMovies(movieId: Int): MoviesDomain
}