package com.example.submissioncapstoneproject.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int? = null,
    val poster: String? = null,
    val title: String? = null,
    val desc: String? = null,
    val date: String? = null,
    val rating: Double? = null,
    val isFavorite: Boolean = false
) : Parcelable