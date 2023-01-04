package com.example.movirapp.data.network.mappers.movie

import com.example.movirapp.data.network.models.movie.MovieDetailsData
import com.example.movirapp.domain.Mapper
import com.example.movirapp.domain.models.movie.MovieDetailsDomain

class MapMovieDetailsToDomain(private val mapper: MapGenresToDomain = MapGenresToDomain(),
): Mapper<MovieDetailsData,MovieDetailsDomain>(
        fromData = { movie ->
            MovieDetailsDomain(
                backdrop_path = movie.backdrop_path,
                budget = movie.budget,
                typeMovie = mapper.mapData(movie.typeMovie),
                movieId = movie.movieId,
                originalLanguage = movie.originalLanguage,
                originalTitle = movie.originalTitle,
                overview = movie.overview,
                popularity = movie.popularity,
                posterPath = movie.posterPath,
                releaseDate = movie.releaseDate,
                runtime = movie.runtime,
                status = movie.status,
                title = movie.title,
                video = movie.video,
                voteAverage = movie.voteAverage,
                voteCount = movie.voteCount,
            )
        }
    )