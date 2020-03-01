package ru.romananchugov.filmsmvvm.data.model

import com.squareup.moshi.Json
import ru.romananchugov.filmsmvvm.domain.model.FilmItemDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository

data class FilmItemDataModel(
    val id: Long,
    val title: String,//required
    val voteAverage: Float,
    val posterPath: String,//required
    val backdropPath: String,
    val overview: String,
    val releaseData: String
)

fun FilmItemDataModel.toDomainModel() = FilmItemDomainModel(
    title = title,
    voteAverage = voteAverage,
    posterPath = FilmsListRepository.FILMS_IMAGE_BASE_URL + posterPath,
    backdropPath = FilmsListRepository.FILMS_IMAGE_BASE_URL + backdropPath,
    overview = overview,
    releaseData = releaseData
)