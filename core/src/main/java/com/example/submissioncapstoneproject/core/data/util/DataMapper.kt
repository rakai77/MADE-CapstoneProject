package com.example.submissioncapstoneproject.core.data.util

import com.example.submissioncapstoneproject.core.data.local.entity.MovieEntity
import com.example.submissioncapstoneproject.core.data.remote.response.MovieResponse
import com.example.submissioncapstoneproject.core.domain.model.Movie

object DataMapper {
    fun mapResponseToEntities(input: List<MovieResponse>) : List<MovieEntity> {
        val list = ArrayList<MovieEntity>()
        input.map {
            val dataMovie = MovieEntity(
                movieId = it.id,
                poster = it.posterPath,
                title = it.title,
                desc = it.overview,
                date = it.releaseDate,
                rating = it.voteAverage,
                isFavorite = false
            )
            list.add(dataMovie)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>) : List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                poster = it.poster,
                title = it.title,
                desc = it.desc,
                date = it.date,
                rating = it.rating,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        poster = input.poster,
        title = input.title,
        desc = input.desc,
        date = input.date,
        rating = input.rating,
        isFavorite = input.isFavorite
    )
}