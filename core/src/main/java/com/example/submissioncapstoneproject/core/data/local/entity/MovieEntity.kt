package com.example.submissioncapstoneproject.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int? = null,

    @ColumnInfo(name = "poster")
    var poster: String? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "desc")
    var desc: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "rating")
    var rating: Double? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)