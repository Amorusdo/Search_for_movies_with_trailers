package com.example.movirapp.data.network.api

import com.example.movirapp.data.network.Endpoints.PEOPLE
import com.example.movirapp.data.network.Endpoints.PERSON_DETAILS
import com.example.movirapp.data.network.models.person.PersonDetailsData
import com.example.movirapp.data.network.models.person.Persons
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonApi {
    @GET(PEOPLE)
    suspend fun getPerson(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Persons


    @GET(PERSON_DETAILS)
    suspend fun getPersonDetails(
        @Path("person_id") id:Int,
        @Query("api_key")api_key:String,
        @Query("language") language: String
    ): PersonDetailsData
}
