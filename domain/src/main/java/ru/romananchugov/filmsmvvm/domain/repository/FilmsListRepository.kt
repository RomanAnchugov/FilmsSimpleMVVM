package ru.romananchugov.filmsmvvm.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel

interface FilmsListRepository{
    fun getFilmsList(): Single<FilmsListDomainModel>
}