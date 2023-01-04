package com.example.movirapp.data.network.models.movie

import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("page") val currentPage: Int,
    @SerializedName("results") val movies: List<MovieData>,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
)