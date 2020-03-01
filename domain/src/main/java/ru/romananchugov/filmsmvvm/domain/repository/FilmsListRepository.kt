package ru.romananchugov.filmsmvvm.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel

interface FilmsListRepository{
    companion object{
        const val FILMS_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w300"
    }
    fun getFilmsList(): Single<FilmsListDomainModel>
}