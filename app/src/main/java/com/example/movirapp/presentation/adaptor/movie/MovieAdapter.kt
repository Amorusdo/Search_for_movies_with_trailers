package com.example.movirapp.presentation.adaptor.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movirapp.R
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.presentation.activities.MovieDetailsActivity
import com.example.movirapp.presentation.adaptor.RvViewHolder

class MovieAdapter(
    private val orientation: Int,
    private val listener: RecyclerOnClickListener) :
    ListAdapter<MovieDomain, RvViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val layout = when (orientation) {
            HORIZONTAL -> R.layout.object_horizontal_item
            PORTRAIT -> R.layout.object_portrait_item
            else -> throw java.lang.RuntimeException("Unknown view type")
        }
        return RvViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bindMovie(getItem(position))
        holder.itemView.setOnClickListener {
            listener.onItemClick(getItem(position))
        }
        holder.itemView.setOnLongClickListener {
            listener.onSaveClick(getItem(position))
            true
        }
    }

    interface RecyclerOnClickListener {
        fun onItemClick(movie: MovieDomain)
        fun onSaveClick(movie: MovieDomain)
    }
    companion object {
        const val PORTRAIT = 100
        const val HORIZONTAL = 101
    }
}