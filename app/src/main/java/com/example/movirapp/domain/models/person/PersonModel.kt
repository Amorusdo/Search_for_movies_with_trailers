package com.example.movirapp.domain.models.person

import android.os.Parcelable
import com.example.movirapp.domain.models.movie.MovieDomain
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonModel(
    val profile_path: String,
    val adult: Boolean,
    val id: Int,
    val known_for: List<MovieDomain>,
    val name: String,
    val popularity: Double
) : Parcelable
