package com.example.submissioncapstoneproject.core.domain.usecase

import com.example.submissioncapstoneproject.core.Resource
import com.example.submissioncapstoneproject.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface UseCase {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovies(): Flow<List<Movie>>

    fun setFavoriteMovies(movie: Movie, state: Boolean)
}