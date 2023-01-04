package com.example.movirapp.domain.models.movie

data class MoviesDomain(
    val currentPage: Int,
    var movies: List<MovieDomain>,
    val totalResults: Int,
    val totalPages: Int,
)
