package com.example.submissioncapstoneproject.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissioncapstoneproject.core.domain.usecase.UseCase

class HomeViewModel(useCase: UseCase) : ViewModel() {

    val movie = useCase.getAllMovies().asLiveData()
}