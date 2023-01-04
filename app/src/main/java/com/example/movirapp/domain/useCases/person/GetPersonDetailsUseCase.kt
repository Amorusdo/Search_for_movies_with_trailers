package com.example.movirapp.domain.useCases.person

import com.example.movirapp.domain.repositories.PersonRepository

class GetPersonDetailsUseCase(private val repository: PersonRepository) {
    suspend fun execute(personId: Int) = repository.getPersonDetails(personId)
}