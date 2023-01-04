package com.example.movirapp.di


import com.example.movirapp.domain.useCases.movie.internet.*
import com.example.movirapp.domain.useCases.movie.storege.GetDeleteMovieUseCase
import com.example.movirapp.domain.useCases.movie.storege.GetSaveMovieUseCase
import com.example.movirapp.domain.useCases.movie.storege.GetStorageMoviesUseCase
import com.example.movirapp.domain.useCases.person.GetPersonDetailsUseCase
import com.example.movirapp.domain.useCases.person.GetPersonUseCase
import com.example.movirapp.domain.useCases.video.GetTrailerUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetNowPlayMoviesUseCase(repository = get())
    }
    factory {
        GetRecommendMoviesUseCase(repository = get())
    }
    factory {
        GetSimilarMoviesUseCase(repository = get())
    }
    factory {
        GetPopularMoviesUseCase(repository = get())
    }
    factory {
        GetTopRatedMoviesUseCase(repository = get())
    }
    factory {
        GetUpcomingUseCase(repository = get())
    }
    factory {
        GetPersonDetailsUseCase(repository = get())
    }
    factory {
        GetMovieDetailsUseCase(repository = get())
    }
    factory {
        GetStorageMoviesUseCase(repository = get())
    }
    factory {
        GetSearchMovieUseCase(repository = get())
    }
    factory {
        GetDeleteMovieUseCase(repository = get())
    }
    factory {
        GetSaveMovieUseCase(repository = get())
    }
    factory {
        GetTrailerUseCase(repository = get())
    }
    factory { GetPersonUseCase(repository = get()) }
}