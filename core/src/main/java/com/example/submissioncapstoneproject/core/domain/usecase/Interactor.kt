package com.example.submissioncapstoneproject.core.domain.usecase

import com.example.submissioncapstoneproject.core.domain.model.Movie
import com.example.submissioncapstoneproject.core.domain.repository.IMovieRepository

class Interactor(private val movieRepository: IMovieRepository): UseCase {

    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getFavoriteMovies() = movieRepository.getFavoriteMovies()

    override fun setFavoriteMovies(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovies(movie, state)
}