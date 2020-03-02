package ru.romananchugov.filmsmvvm.data.model

import com.squareup.moshi.Json
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import java.util.*


data class FilmsNWResponse(
    @field:Json(name = "results") val result: List<FilmItemNWResponse>
)

fun FilmsNWResponse.toDataModel() = FilmsListDataModel(
    filmsList = this.result.map { it.toDataModel() }
)