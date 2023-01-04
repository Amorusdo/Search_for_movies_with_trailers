package com.example.movirapp.data.network

object Endpoints {
    const val NOW_PLAYING = "movie/now_playing"
    const val POPULAR = "movie/popular"
    const val TOP_RATED = "movie/top_rated"
    const val UPCOMING = "movie/upcoming"

    const val MOVIE_DETAILS = "movie/{movie_id}"
    const val RECOMMEND_MOVIES ="movie/{movie_id}/recommendations"
    const val SIMILAR_MOVIES ="movie/{movie_id}/similar"

    const val SEARCH_MOVIES = "search/movie"

    const val GET_VIDEO = "movie/{movie_id}/videos"

    const val PEOPLE = "person/popular"
    const val SEARCH_PEOPLE = "search/person"

    const val PERSON_DETAILS = "person/{person_id}"
}