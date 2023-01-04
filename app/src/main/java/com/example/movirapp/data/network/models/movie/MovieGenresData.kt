package com.example.movirapp.data.network.models.movie

import com.google.gson.annotations.SerializedName

data class MovieGenresData (
    @SerializedName("id")  val personId : Int,
    @SerializedName("name") val personName : String
    )