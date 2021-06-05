package com.example.submissioncapstoneproject

import com.example.submissioncapstoneproject.core.domain.usecase.Interactor
import com.example.submissioncapstoneproject.core.domain.usecase.UseCase
import com.example.submissioncapstoneproject.detail.DetailMovieViewModel
import com.example.submissioncapstoneproject.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UseCase> { Interactor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }

}