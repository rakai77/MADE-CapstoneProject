package com.example.submissioncapstoneproject.core.data.remote.network

import com.example.submissioncapstoneproject.core.data.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getListMovie(
        @Query("api_key") apiKey: String = "b917efbd6df2adf02c62cf3b78882e78"
    ) : ListMovieResponse
}