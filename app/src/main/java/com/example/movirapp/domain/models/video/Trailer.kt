package com.example.movirapp.domain.models.video

import com.google.gson.annotations.SerializedName

class Trailer (
    @SerializedName("name") val trailerName: String,
    @SerializedName("key") val trailerKey : String,
    @SerializedName("official") val isOfficial : Boolean
)