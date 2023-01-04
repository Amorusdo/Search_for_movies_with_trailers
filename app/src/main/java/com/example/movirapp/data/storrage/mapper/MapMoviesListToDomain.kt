package com.example.movirapp.data.storrage.mapper

import com.example.movirapp.data.storrage.models.MovieStorage
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MovieDomain

class MapMoviesListToDomain(
    private val mapper: MapMovieFromStorageToDomain = MapMovieFromStorageToDomain()
) : Mapper<List<MovieStorage>, List<MovieDomain>>(
    fromData = {
        it.map { movie ->
            mapper.mapData(movie)
        }
    }
)