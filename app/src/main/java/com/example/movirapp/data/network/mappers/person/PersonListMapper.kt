package com.example.movirapp.data.network.mappers.person

import com.example.movirapp.data.network.mappers.movie.MapMovieListToDomain
import com.example.movirapp.data.network.models.person.PersonData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.person.PersonModel


class PersonListMapper(private val mapper: MapMovieListToDomain = MapMovieListToDomain()) :
    Mapper<List<PersonData>, List<PersonModel>>(
        fromData = {
            it.map { person ->
                PersonModel(
                    profile_path = person.profile_path ?: "",
                    adult = person.adult,
                    id = person.id,
                    known_for = mapper.mapData(person.known_for),
                    name = person.name,
                    popularity = person.popularity
                )
            }
        }
    )

