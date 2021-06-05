package com.example.submissioncapstoneproject.core.data.local.room

import androidx.room.*
import com.example.submissioncapstoneproject.core.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntities")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieEntities where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateFavoriteMovies(movie: MovieEntity)
}