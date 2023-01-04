package com.example.movirapp.domain.models.person

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PersonDetailsDomain(
    val birthday: String?,
    val deathDay: String?,
    val personId: Int,
    val personName: String,
    val alsoKnownAs: List<String>,
    val gender: String,
    val biography: String,
    val popularity: Double,
    val placeOfBirth: String?,
    val profileImage: String?
) : Parcelable