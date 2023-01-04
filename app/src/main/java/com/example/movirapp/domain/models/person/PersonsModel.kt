package com.example.movirapp.domain.models.person

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonsModel(
    val page: Int,
    val persons: List<PersonModel>,
    val total_results: Int,
    val total_pages: Int
) : Parcelable, List<PersonModel> {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: PersonModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<PersonModel>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): PersonModel {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: PersonModel): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<PersonModel> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: PersonModel): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<PersonModel> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<PersonModel> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<PersonModel> {
        TODO("Not yet implemented")
    }
}
