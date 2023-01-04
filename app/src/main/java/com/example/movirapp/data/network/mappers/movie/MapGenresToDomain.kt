package com.example.movirapp.data.network.mappers.movie

import com.example.movirapp.data.network.models.movie.MovieGenresData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MovieGenderDomain

class MapGenresToDomain : Mapper<List<MovieGenresData>,List<MovieGenderDomain>>(
    fromData = { list->
        list.map {genre->
            MovieGenderDomain(
                personId = genre.personId,
                personName = genre.personName
            )
        }
    }
)


