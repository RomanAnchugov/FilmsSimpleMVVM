package ru.romananchugov.filmsmvvm.domain.model

data class FilmItemDomainModel(
    val title: String,//required
    val voteAverage: Float,
    val posterPath: String,//required
    val backdropPath: String,
    val overview: String,
    val releaseData: String
)