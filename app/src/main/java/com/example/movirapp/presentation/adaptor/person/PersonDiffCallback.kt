package com.example.movirapp.presentation.adaptor.person

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.movirapp.domain.models.person.PersonDetailsDomain

class PersonDiffCallback : DiffUtil.ItemCallback<PersonDetailsDomain>() {

    override fun areItemsTheSame(oldItem: PersonDetailsDomain, newItem: PersonDetailsDomain
    ): Boolean = oldItem.personId == newItem.personId



    override fun areContentsTheSame(oldItem: PersonDetailsDomain, newItem: PersonDetailsDomain
    ): Boolean {
        return oldItem == newItem}
}