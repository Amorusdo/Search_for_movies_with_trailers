package com.example.movirapp.data.network.api

import com.example.movirapp.data.network.Endpoints.MOVIE_DETAILS
import com.example.movirapp.data.network.Endpoints.NOW_PLAYING
import com.example.movirapp.data.network.Endpoints.POPULAR
import com.example.movirapp.data.network.Endpoints.RECOMMEND_MOVIES
import com.example.movirapp.data.network.Endpoints.SEARCH_MOVIES
import com.example.movirapp.data.network.Endpoints.SIMILAR_MOVIES
import com.example.movirapp.data.network.Endpoints.TOP_RATED
import com.example.movirapp.data.network.Endpoints.UPCOMING
import com.example.movirapp.data.network.models.movie.MovieDetailsData
import com.example.movirapp.data.network.models.movie.MoviesData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET(POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MoviesData

    @GET(NOW_PLAYING)
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MoviesData

    @GET(TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MoviesData

    @GET(UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MoviesData

    @GET(SEARCH_MOVIES)
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("language") language: String,
    ): MoviesData

    @GET(MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): MovieDetailsData

    @GET(RECOMMEND_MOVIES)
    suspend fun getRecommendMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): MoviesData

    @GET(SIMILAR_MOVIES)
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): MoviesData
}