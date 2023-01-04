package com.example.movirapp.data.network.servise


import com.example.movirapp.data.network.Utils
import com.example.movirapp.data.network.api.VideoApi
import com.example.movirapp.domain.models.video.Videos
import com.example.movirapp.domain.repositories.VideoRepository

class VideoRepositoryImpl(private val api: VideoApi) : VideoRepository {
    override suspend fun getTrailers(movieId: Int): Videos =
        api.getVideo(movieId,Utils.API_KEY, "en")
}