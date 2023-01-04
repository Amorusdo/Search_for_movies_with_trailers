package com.example.movirapp.data.network.api

import com.example.movirapp.data.network.Endpoints.GET_VIDEO
import com.example.movirapp.domain.models.video.Videos
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VideoApi {

    @GET(GET_VIDEO)
    suspend fun getVideo(
        @Path("movie_id") movieId :Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Videos
}