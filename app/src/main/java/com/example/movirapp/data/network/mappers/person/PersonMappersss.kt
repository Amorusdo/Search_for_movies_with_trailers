package com.example.movirapp.data.network.mappers.person

import com.example.movirapp.data.network.models.person.Persons
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.person.PersonsModel

class PersonMappersss (private val mapper: PersonListMapper = PersonListMapper()) :
    Mapper<Persons, PersonsModel>(
        fromData = {
            PersonsModel(
                page = it.page,
                persons = mapper.mapData(it.persons),
                total_results = it.total_results,
                total_pages = it.total_pages
            )
        }
    )
