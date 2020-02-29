package ru.romananchugov.filmsmvvm.model.ext

import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import ru.romananchugov.filmsmvvm.model.FilmsListPresentationModel

fun FilmsListDomainModel.toPresentationModel() = FilmsListPresentationModel(
    test = this.lol + 1
)