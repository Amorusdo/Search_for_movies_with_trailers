package com.example.movirapp.data.network.servise

import android.annotation.SuppressLint
import com.example.movirapp.data.network.Utils
import com.example.movirapp.data.network.api.PersonApi
import com.example.movirapp.data.network.mappers.person.MapPersonDetailsToDomain

import com.example.movirapp.data.network.mappers.person.PersonMappersss

import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.domain.models.person.PersonModel

import com.example.movirapp.domain.models.person.PersonsModel
import com.example.movirapp.domain.repositories.PersonRepository

class PersonRepositoryImpl(
    private val api: PersonApi
) : PersonRepository{

    private val mapper = MapPersonDetailsToDomain()
    private val mapPerson = PersonMappersss()


    @SuppressLint("SuspiciousIndentation")
    override suspend fun getPersons(page: Int): List<PersonModel> {
      val response = api.getPerson(Utils.API_KEY,"ru", page = page)
        return mapPerson.mapData(response)
    }


    override suspend fun getPersonDetails(personId: Int): PersonDetailsDomain {
        val response = api.getPersonDetails(personId, Utils.API_KEY, "ru")
        return mapper.mapData(response)
    }
}