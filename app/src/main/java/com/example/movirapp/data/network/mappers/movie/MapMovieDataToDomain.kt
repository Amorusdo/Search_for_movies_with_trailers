package com.example.movirapp.data.network.mappers.movie

import com.example.movirapp.data.network.models.movie.MovieData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MovieDomain

class MapMovieDataToDomain : Mapper< MovieData,MovieDomain>(
    fromData = { movie ->
        MovieDomain(
            posterPath = movie.posterPath,
            adult = movie.adult,
            overview = movie.overview,
            releaseDate = movie.releaseDate,
            actorsId = movie.actorId.map { ids ->
                ids
            },
            movieId = movie.movieId,
            originalTitle = movie.originalTitle,
            originalLanguage = movie.originalLanguage,
            backdropPath = movie.backdropPath,
            rating = movie.rating,
            movieTitle = movie.movieTitle,
            voteCount = movie.voteCount,
            isHasVideo = movie.isHasVideo,
            voteAverage = movie.voteAverage,
        )
    }
)