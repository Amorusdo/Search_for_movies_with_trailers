package com.example.movirapp.domain.models.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDomain(
    val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String?,
    val movieId: Int,
    val originalTitle: String?,
    val originalLanguage: String,
    val backdropPath: String?,
    val rating: Double,
    val movieTitle: String?,
    val voteCount: Int,
    val isHasVideo: Boolean,
    val voteAverage: Double,
    val actorsId: List<Int>,
):Parcelable