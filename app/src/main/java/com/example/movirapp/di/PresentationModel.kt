package com.example.movirapp.di

import com.example.movirapp.presentation.viewModel.MovieDetailsViewModel
import com.example.movirapp.presentation.viewModel.MoviesViewModel
import com.example.movirapp.presentation.viewModel.PersonViewModel
import com.example.movirapp.presentation.viewModel.SearchMovieVieModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    viewModel {
        MovieDetailsViewModel(
            getMovieDetailsUseCase = get(),
            getGetPersonUseCase = get(),
            getRecommendMoviesUseCase = get(),
            getSimilarMoviesUseCase = get(),
            getSaveMovieUseCase = get(),
            getTrailerUseCase = get()
        )
    }
    viewModel {
        MoviesViewModel(
            getNowPlayMoviesUseCase = get(),
            getPopularMoviesUseCase = get(),
            getTopRatedMoviesUseCase = get(),
            getUpcomingUseCase = get(),
            getSaveMovieUseCase = get(),
        )
    }
    viewModel {
        SearchMovieVieModel(
            searchMovieUseCase = get(),
        )
    }
    viewModel{
        PersonViewModel(
            getGetPersonUseCase = get()
        )
    }
}

