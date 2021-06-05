package com.example.submissioncapstoneproject.detail

import androidx.lifecycle.ViewModel
import com.example.submissioncapstoneproject.core.domain.model.Movie
import com.example.submissioncapstoneproject.core.domain.usecase.UseCase

class DetailMovieViewModel(private val useCase: UseCase) : ViewModel() {
    fun setFavoriteMovies(movie: Movie, newStatus: Boolean) =
        useCase.setFavoriteMovies(movie, newStatus)
}