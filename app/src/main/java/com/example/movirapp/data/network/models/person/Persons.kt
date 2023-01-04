package com.example.movirapp.data.network.models.person

import com.google.gson.annotations.SerializedName

data class Persons(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val persons: List<PersonData>,
    @SerializedName("total_results") val total_results: Int,
    @SerializedName("total_pages") val total_pages: Int
)