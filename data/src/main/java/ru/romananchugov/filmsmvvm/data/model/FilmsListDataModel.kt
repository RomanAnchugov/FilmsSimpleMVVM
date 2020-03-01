package ru.romananchugov.filmsmvvm.data.model

import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel

//TODO
data class FilmsListDataModel(
    val loadTimeMillis: Long,
    val filmsList: List<FilmItemDataModel>
)

fun FilmsListDataModel.toDomainModel() = FilmsListDomainModel(
    loadTimeMillis = loadTimeMillis,
    filmsList = filmsList.map { it.toDomainModel() }
)