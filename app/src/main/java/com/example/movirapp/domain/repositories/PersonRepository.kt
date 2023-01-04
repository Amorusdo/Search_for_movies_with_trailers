package com.example.movirapp.domain.repositories

import com.example.movirapp.data.network.models.person.PersonData
import com.example.movirapp.data.network.models.person.Persons
import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.domain.models.person.PersonModel
import com.example.movirapp.domain.models.person.PersonsModel

interface PersonRepository {
    suspend fun getPersons( page : Int): List<PersonModel>
    suspend fun getPersonDetails(personId : Int):PersonDetailsDomain
}
