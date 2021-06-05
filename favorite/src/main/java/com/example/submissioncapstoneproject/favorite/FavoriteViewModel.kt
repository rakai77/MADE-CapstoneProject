package com.example.submissioncapstoneproject.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissioncapstoneproject.core.domain.usecase.UseCase

class FavoriteViewModel(useCase: UseCase) : ViewModel() {
    val favoriteMovie = useCase.getFavoriteMovies().asLiveData()
}