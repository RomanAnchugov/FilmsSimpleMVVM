package ru.romananchugov.filmsmvvm.data.model

import com.squareup.moshi.Json
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import java.util.*


data class FilmsNWResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "total_results") val totalResults: Int,
    @field:Json(name = "total_pages") val totalPages: Int,
    @field:Json(name = "results") val result: List<FilmItemNWResponse>
)

fun FilmsNWResponse.toDataModel() = FilmsListDataModel(
    loadTimeMillis = Calendar.getInstance().timeInMillis,
    filmsList = this.result.map { it.toDataModel() }
)