package com.example.movirapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.domain.useCases.person.GetPersonDetailsUseCase
import kotlinx.coroutines.launch

class PersonViewModel (
    private val getGetPersonUseCase: GetPersonDetailsUseCase,
        ) : ViewModel() {

    private val _persons: MutableLiveData<List<PersonDetailsDomain>> = MutableLiveData()
    val person: LiveData<List<PersonDetailsDomain>> get() = _persons

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error




    fun getPersons(personsId: List<Int>) = viewModelScope.launch {
        val personsList = mutableListOf<PersonDetailsDomain>()
        if (personsId.isNotEmpty()) {
            for (i in personsId.indices) {
                kotlin.runCatching {
                    getGetPersonUseCase.execute(personsId[i])
                }
                    .onSuccess {
                        personsList.add(it)
                    }
                    .onFailure {
                        _error.value = it.message
                    }
            }
            if (personsList.isNotEmpty()) {
                _persons.value = personsList
            }
        }
    }

}