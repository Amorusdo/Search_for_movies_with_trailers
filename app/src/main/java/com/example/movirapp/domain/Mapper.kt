package com.example.movirapp.domain

import com.example.movirapp.data.network.models.person.PersonData


open class Mapper<Data, Domain>(
    private val fromData: (Data) -> Domain = { TODO() },
    private val fromDomain: (Domain) -> Data = { TODO() }
) {
    fun mapData(t: Data): Domain = fromData(t)
    fun mapDomain(d: Domain): Data = fromDomain(d)
}