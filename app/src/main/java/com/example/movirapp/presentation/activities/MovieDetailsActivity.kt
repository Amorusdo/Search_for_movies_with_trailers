package com.example.movirapp.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movirapp.data.network.Utils
import com.example.movirapp.databinding.ActivityMovieDetailsBinding
import com.example.movirapp.domain.models.movie.MovieDomain
import com.example.movirapp.domain.models.person.PersonDetailsDomain
import com.example.movirapp.presentation.adaptor.movie.MovieAdapter
import com.example.movirapp.presentation.adaptor.person.PersonAdapter
import com.example.movirapp.presentation.viewModel.MovieDetailsViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : AppCompatActivity(),
    PersonAdapter.RecyclerOnClickListener,
    MovieAdapter.RecyclerOnClickListener {

   private val binding:ActivityMovieDetailsBinding by lazy {
       ActivityMovieDetailsBinding.inflate(layoutInflater)
   }


    private val viewModel by viewModel<MovieDetailsViewModel>()

    private val personAdapter: PersonAdapter by lazy {
        PersonAdapter(this)
    }

    private val similarMovieAdapter: MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.HORIZONTAL, this)
    }

    private val recommendMovieAdapter: MovieAdapter by lazy {
        MovieAdapter(MovieAdapter.HORIZONTAL, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<MovieDomain>(MOVIE)

        setAdapters()
        makeResponse(movie!!)
        observeViewModel()
    }

    private fun setAdapters() {
        binding.rvActorsInMovie.adapter = personAdapter
        binding.rvSimilarMovie.adapter = similarMovieAdapter
        binding.rvRecommendMovie.adapter = recommendMovieAdapter
    }

    private fun makeResponse(movie: MovieDomain) {
        viewModel.getMovieDetails(movie.movieId)
        viewModel.getPersons(movie.actorsId)
        viewModel.getSimilarMovies(movie.movieId)
        viewModel.getRecommendMovies(movie.movieId)
        viewModel.getTrailer(movie.movieId)
    }

    private fun observeViewModel() {
        viewModel.movie.observe(this) {
            parseToolbar(it.title)
            Picasso.get().load(Utils.IMAGE_PATH + it.backdrop_path).into(binding.movieImage)
            binding.movieTitle.text = it.title
            binding.movieVoteCount.text = it.voteCount.toString()
        }
        viewModel.person.observe(this) {
            personAdapter.submitList(it)
        }
        viewModel.recommendMovies.observe(this) {
            recommendMovieAdapter.submitList(it)
        }
        viewModel.similarMovies.observe(this) {
            similarMovieAdapter.submitList(it)
        }
        viewModel.trailer.observe(this) {
            startTrailer(it.trailerKey)
        }
    }

    private fun parseToolbar(movieTitle: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = movieTitle

    }

    companion object {
        fun launchMovieDetailsActivity(context: Context, movie: MovieDomain): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE, movie)
            return intent
        }
        const val MOVIE = "movie"
    }

    override fun onItemClick(person: PersonDetailsDomain) {

    }

    override fun onItemClick(movie: MovieDomain) {
        startActivity(launchMovieDetailsActivity(this, movie))
    }

    override fun onSaveClick(movie: MovieDomain) {

    }

    private fun startTrailer(videoKey: String) {
        binding.youtubePlayer.addYouTubePlayerListener(object : YouTubePlayerListener {
            override fun onApiChange(youTubePlayer: YouTubePlayer) {

            }

            override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
            }

            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
            }

            override fun onPlaybackQualityChange(
                youTubePlayer: YouTubePlayer,
                playbackQuality: PlayerConstants.PlaybackQuality
            ) {
            }

            override fun onPlaybackRateChange(
                youTubePlayer: YouTubePlayer,
                playbackRate: PlayerConstants.PlaybackRate
            ) {
            }

            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(videoKey, 0f)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
            }

            override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {
            }

            override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {
            }

            override fun onVideoLoadedFraction(
                youTubePlayer: YouTubePlayer,
                loadedFraction: Float
            ) {
            }
        })
    }
}