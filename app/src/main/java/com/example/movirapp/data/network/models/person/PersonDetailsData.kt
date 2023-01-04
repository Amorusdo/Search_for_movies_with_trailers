package com.example.movirapp.data.network.models.person

import com.google.gson.annotations.SerializedName

data class PersonDetailsData(
    @SerializedName("known_for_department") val known_for_department: String,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("deathday") val deathDay: String?,
    @SerializedName("id") val personId: Int,
    @SerializedName("name") val personName: String,
    @SerializedName("also_known_as") val alsoKnownAs: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("biography") val biography: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("place_of_birth") val placeOfBirth: String?,
    @SerializedName("profile_path") val profileImage: String?
)