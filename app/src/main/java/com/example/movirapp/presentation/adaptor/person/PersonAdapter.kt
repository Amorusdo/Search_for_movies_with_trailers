package com.example.movirapp.presentation.adaptor.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movirapp.R
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.presentation.activities.MovieDetailsActivity
import com.example.movirapp.presentation.adaptor.RvViewHolder

class PersonAdapter(
    private val listener: MovieDetailsActivity,

    ) : ListAdapter<PersonDetailsDomain, RvViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder =
        RvViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.object_horizontal_item, parent, false)
        )

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bindPerson(getItem(position))
        holder.itemView.setOnClickListener {
            listener.onItemClick(getItem(position))
        }
    }

    interface RecyclerOnClickListener {
        fun onItemClick(person: PersonDetailsDomain)
    }
}