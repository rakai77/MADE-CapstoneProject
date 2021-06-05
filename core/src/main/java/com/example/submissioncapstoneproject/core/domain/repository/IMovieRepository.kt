package com.example.submissioncapstoneproject.core.domain.repository

import com.example.submissioncapstoneproject.core.Resource
import com.example.submissioncapstoneproject.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovies(): Flow<List<Movie>>

    fun setFavoriteMovies(movies: Movie, state: Boolean)
}