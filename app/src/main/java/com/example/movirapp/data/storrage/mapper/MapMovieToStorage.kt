package com.example.movirapp.data.storrage.mapper

import com.example.movirapp.data.storrage.models.MovieStorage
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MovieDomain

class MapMovieToStorage : Mapper<MovieStorage,MovieDomain>(
    fromDomain = { movie ->
        MovieStorage(
            posterPath = movie.posterPath,
            adult = movie.adult,
            overview = movie.overview,
            releaseDate = movie.releaseDate,
            actorsId = movie.actorsId.map { ids ->
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