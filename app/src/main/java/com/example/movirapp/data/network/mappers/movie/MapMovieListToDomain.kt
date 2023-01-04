package com.example.movirapp.data.network.mappers.movie

import com.example.movirapp.domain.Mapper
import com.example.movirapp.data.network.models.movie.MovieData
import com.example.movirapp.domain.models.movie.MovieDomain

class MapMovieListToDomain(private val mapper: MapMovieDataToDomain = MapMovieDataToDomain()
): Mapper<List<MovieData>, List<MovieDomain>>(
    fromData = {
        it.map{ movie -> mapper.mapData(movie)
        }
    }
)
