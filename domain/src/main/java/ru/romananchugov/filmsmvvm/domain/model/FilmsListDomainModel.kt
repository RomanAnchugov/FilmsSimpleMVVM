package ru.romananchugov.filmsmvvm.domain.model

data class FilmsListDomainModel(
    val loadTimeMillis: Long,
    val filmsList: List<FilmItemDomainModel>
)