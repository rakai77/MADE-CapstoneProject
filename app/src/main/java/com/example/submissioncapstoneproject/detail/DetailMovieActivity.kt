package com.example.submissioncapstoneproject.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.submissioncapstoneproject.R
import com.example.submissioncapstoneproject.databinding.ActivityDetailMovieBinding
import com.example.submissioncapstoneproject.core.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.tvDetailDescription.text = detailMovie.desc
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/original${detailMovie.poster}")
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovies(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white__24dp))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_unfavorite_border_24dp))
        }
    }

}