package ru.romananchugov.filmsmvvm.data.model

import com.squareup.moshi.Json

data class FilmItemNWResponse(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "title") val title: String,//required
    @field:Json(name = "vote_average") val voteAverage: Float,
    @field:Json(name = "poster_path") val posterPath: String,//required
    @field:Json(name = "backdrop_path") val backdropPath: String,
    @field:Json(name = "overview") val overview: String,
    @field:Json(name = "release_date") val releaseData: String
)