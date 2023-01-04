package com.example.movirapp.domain.models.video

import com.google.gson.annotations.SerializedName

class Videos(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val trailers: List<Trailer>
)