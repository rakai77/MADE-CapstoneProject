package com.example.submissioncapstoneproject.core

import com.example.submissioncapstoneproject.core.data.local.LocalDataSource
import com.example.submissioncapstoneproject.core.data.remote.RemoteDataSource
import com.example.submissioncapstoneproject.core.data.remote.network.ApiResponse
import com.example.submissioncapstoneproject.core.data.remote.response.MovieResponse
import com.example.submissioncapstoneproject.core.data.util.AppExecutors
import com.example.submissioncapstoneproject.core.data.util.DataMapper
import com.example.submissioncapstoneproject.core.domain.model.Movie
import com.example.submissioncapstoneproject.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieCatalogueRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val list = DataMapper.mapResponseToEntities(data)
                localDataSource.insertMovies(list)
            }
        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(movies: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movies)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovies(movieEntity,state)
        }
    }

}