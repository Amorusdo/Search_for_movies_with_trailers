package com.example.movirapp.data.storrage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.movirapp.data.storrage.TypeConvertor

@Entity(tableName = "movieTable")
class MovieStorage(
    @PrimaryKey(autoGenerate = true)
    val movieId: Int,
    val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String?,
    @TypeConverters(TypeConvertor::class)
    val actorsId: List<Int>,
    val originalTitle: String?,
    val originalLanguage: String,
    val movieTitle: String?,
    val backdropPath: String?,
    val rating: Double,
    val voteCount: Int,
    val isHasVideo: Boolean,
    val voteAverage: Double
)