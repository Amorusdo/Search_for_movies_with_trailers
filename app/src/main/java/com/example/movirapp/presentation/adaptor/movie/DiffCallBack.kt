package com.example.movirapp.presentation.adaptor.movie

import androidx.recyclerview.widget.DiffUtil
import com.example.movirapp.domain.models.movie.MovieDomain

class DiffCallBack:DiffUtil.ItemCallback<MovieDomain>() {
    override fun areItemsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean =
        oldItem.movieId == newItem.movieId

    override fun areContentsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean {
      return  oldItem == newItem
    }
}