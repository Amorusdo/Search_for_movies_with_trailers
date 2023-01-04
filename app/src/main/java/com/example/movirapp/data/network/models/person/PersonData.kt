package com.example.movirapp.data.network.models.person

import com.example.movirapp.data.network.models.movie.MovieData
import com.google.gson.annotations.SerializedName

class PersonData (
    @SerializedName("profile_path") val profile_path: String?,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("known_for") val known_for: List<MovieData>,
    @SerializedName("name") val name: String,
    @SerializedName("popularity") val popularity: Double
    )