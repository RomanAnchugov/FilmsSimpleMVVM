package ru.romananchugov.filmsmvvm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.romananchugov.filmsmvvm.domain.model.FilmItemDomainModel

@Parcelize
data class FilmItemPresentationModel(
    val title: String,//required
    val voteAverage: Float,
    val posterPath: String,//required
    val backdropPath: String,
    val overview: String,
    val releaseData: String
) : Parcelable

fun FilmItemDomainModel.toPresentationModel() = FilmItemPresentationModel(
    title = title,
    voteAverage = voteAverage,
    posterPath = posterPath,
    backdropPath = backdropPath,
    overview = overview,
    releaseData = releaseData
)