package com.example.movirapp.domain.models.movie

data class MovieDetailsDomain(
    val backdrop_path: String?,
    val budget: Int,
    val typeMovie: List<MovieGenderDomain>,
    val movieId: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val runtime: Int?,
    val status: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)