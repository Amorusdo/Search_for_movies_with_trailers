package com.example.movirapp.data.network.mappers.movie

import com.example.movirapp.data.network.models.movie.MoviesData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MoviesDomain

class MapMoviesDataToDomain(
    private val mapper: MapMovieListToDomain = MapMovieListToDomain()
) : Mapper< MoviesData,MoviesDomain>(
    fromData = { movies ->
        MoviesDomain(
            currentPage = movies.currentPage,
            movies = mapper.mapData(movies.movies),
            totalResults = movies.totalResults,
            totalPages = movies.totalPages,
        )
    }
)