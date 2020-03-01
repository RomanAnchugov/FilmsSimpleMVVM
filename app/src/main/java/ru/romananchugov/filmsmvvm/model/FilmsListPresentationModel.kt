package ru.romananchugov.filmsmvvm.model

import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel

data class FilmsListPresentationModel(
    val filmsList: List<FilmsItemPresentationModel>
)

fun FilmsListDomainModel.toPresentationModel() = FilmsListPresentationModel(
    filmsList = filmsList.map { it.toPresentationModel() }
)