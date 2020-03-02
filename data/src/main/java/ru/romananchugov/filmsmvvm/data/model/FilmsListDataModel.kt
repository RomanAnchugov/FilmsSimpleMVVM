package ru.romananchugov.filmsmvvm.data.model

import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel

data class FilmsListDataModel(
    val filmsList: List<FilmItemDataModel>
)

fun FilmsListDataModel.toDomainModel() = FilmsListDomainModel(
    filmsList = filmsList.map { it.toDomainModel() }
)