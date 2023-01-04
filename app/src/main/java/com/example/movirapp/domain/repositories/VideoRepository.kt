package com.example.movirapp.domain.repositories

import com.example.movirapp.domain.models.video.Videos

interface VideoRepository {
    suspend fun  getTrailers(movieId: Int): Videos
}