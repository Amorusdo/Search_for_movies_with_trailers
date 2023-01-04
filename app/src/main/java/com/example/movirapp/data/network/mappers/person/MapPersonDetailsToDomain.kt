package com.example.movirapp.data.network.mappers.person

import com.example.movirapp.data.network.models.person.PersonDetailsData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.person.PersonDetailsDomain

class MapPersonDetailsToDomain : Mapper<PersonDetailsData,PersonDetailsDomain>(
    fromData = { person ->
        PersonDetailsDomain(
            birthday = person.birthday,
            deathDay = person.deathDay,
            personId = person.personId,
            personName = person.personName,
            alsoKnownAs = person.alsoKnownAs.map { it },
            gender = person.gender,
            biography = person.biography,
            popularity = person.popularity,
            placeOfBirth = person.placeOfBirth,
            profileImage = person.profileImage,
        )
    }
)
