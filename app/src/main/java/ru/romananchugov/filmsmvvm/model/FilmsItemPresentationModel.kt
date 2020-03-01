package ru.romananchugov.filmsmvvm.model

import ru.romananchugov.filmsmvvm.domain.model.FilmItemDomainModel

data class FilmsItemPresentationModel(
    val title: String,//required
    val voteAverage: Float,
    val posterPath: String,//required
    val backdropPath: String,
    val overview: String,
    val releaseData: String
)

fun FilmItemDomainModel.toPresentationModel() = FilmsItemPresentationModel(
    title = title,
    voteAverage = voteAverage,
    posterPath = posterPath,
    backdropPath = backdropPath,
    overview = overview,
    releaseData = releaseData
)