package com.example.movirapp.domain.useCases.person

import com.example.movirapp.domain.models.person.PersonsModel
import com.example.movirapp.domain.repositories.PersonRepository

class GetPersonUseCase(private val repository: PersonRepository) {
    suspend fun execute(page:Int) =
        repository.getPersons(page)
}