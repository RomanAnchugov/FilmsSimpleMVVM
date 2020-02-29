package ru.romananchugov.filmsmvvm.data.model

import com.squareup.moshi.Json
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel


data class FilmsNWResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "total_results") val totalResults: Int,
    @field:Json(name = "total_pages") val totalPages: Int,
    @field:Json(name = "results") val result: List<FilmItemNWResponse>
)

fun FilmsNWResponse.toDomainModel() = FilmsListDomainModel(
    lol = this.page
)