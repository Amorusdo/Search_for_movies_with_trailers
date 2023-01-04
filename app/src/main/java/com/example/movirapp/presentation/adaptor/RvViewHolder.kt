package com.example.movirapp.presentation.adaptor

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movirapp.R
import com.example.movirapp.data.network.Utils
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.squareup.picasso.Picasso
import com.vaibhavlakhera.circularprogressview.CircularProgressView

class RvViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.item_image)
    private val process: CircularProgressView = view.findViewById(R.id.progressBar)

    fun bindPerson(person:PersonDetailsDomain){
        bind(person.profileImage,person.popularity)
    }
    fun bindMovie(movie: MovieDomain){
        bind(movie.posterPath,movie.voteAverage)
    }

   private fun bind(imagePath:String?,voteAverage:Double) {
        val movieProcess = voteAverage * 10
        if (imagePath != null) {
            Picasso.get().load(Utils.IMAGE_PATH + imagePath).into(image)
        }
        if (movieProcess <= 50) {
            process.setProgressColorRes(R.color.red)
        } else if (movieProcess.toInt() in 51..75) {
            process.setProgressColorRes(R.color.yellow)
        } else {
            process.setProgressColorRes(R.color.green)
        }
        process.setProgress(movieProcess.toInt())
    }
}