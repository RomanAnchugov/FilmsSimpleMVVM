package ru.romananchugov.filmsmvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.romananchugov.filmsmvvm.domain.model.FilmItemDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository

@Entity(tableName = "films")
data class FilmItemDataModel(
    @PrimaryKey val id: Long,
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
    posterPath = FilmsListRepository.FILMS_IMAGE_SMALL_BASE_URL + posterPath,
    backdropPath = FilmsListRepository.FILMS_IMAGE_BIG_BASE_URL + backdropPath,
    overview = overview,
    releaseData = releaseData
)