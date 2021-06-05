package com.example.submissioncapstoneproject.core.di

import androidx.room.Room
import com.example.submissioncapstoneproject.core.MovieCatalogueRepository
import com.example.submissioncapstoneproject.core.data.local.LocalDataSource
import com.example.submissioncapstoneproject.core.data.local.room.MovieDatabase
import com.example.submissioncapstoneproject.core.data.remote.RemoteDataSource
import com.example.submissioncapstoneproject.core.data.remote.network.ApiService
import com.example.submissioncapstoneproject.core.data.util.AppExecutors
import com.example.submissioncapstoneproject.core.domain.repository.IMovieRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movie.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> { MovieCatalogueRepository(get(), get(), get()) }
}