package com.example.movirapp.domain.useCases.video

import com.example.movirapp.domain.models.video.Trailer
import com.example.movirapp.domain.repositories.VideoRepository

class GetTrailerUseCase(private val repository: VideoRepository) {
    suspend fun execute(movieId: Int): Trailer {
        val videos = repository.getTrailers(movieId).trailers
        var trailer: Trailer? = null
        if (videos.size > 1) {
            for (i in videos.indices) {
                if (videos[i].isOfficial == true) {
                    trailer = videos[i]
                    break
                }
            }
            if (trailer == null) {
                trailer = videos[0]
            }
        } else {
            trailer = videos[0]
        }
        return trailer
    }
}