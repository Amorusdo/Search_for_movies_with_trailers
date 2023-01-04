package com.example.movirapp.di

import com.example.movirapp.data.network.RetrofitInstance
import com.example.movirapp.data.network.servise.MovieRepositoryImpl
import com.example.movirapp.data.network.servise.PersonRepositoryImpl
import com.example.movirapp.data.network.servise.VideoRepositoryImpl
import com.example.movirapp.data.storrage.servise.MovieStorageRepositoryImpl
import com.example.movirapp.domain.repositories.VideoRepository
import com.example.movirapp.domain.repositories.MovieRepository
import com.example.movirapp.domain.repositories.MovieStorageRepository
import com.example.movirapp.domain.repositories.PersonRepository
import org.koin.dsl.module

val dataModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(api = RetrofitInstance.movieApi)
    }

    single<PersonRepository> {
        PersonRepositoryImpl(api = RetrofitInstance.personApi)
    }

    single<MovieStorageRepository> {
        MovieStorageRepositoryImpl(application = get())
    }

    single <VideoRepository>{
        VideoRepositoryImpl( api = RetrofitInstance.videoApi)
    }
}