package ru.romananchugov.filmsmvvm.data.repository

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.data.BaseRepository
import ru.romananchugov.filmsmvvm.data.data_source.FilmsService
import ru.romananchugov.filmsmvvm.data.model.toDataModel
import ru.romananchugov.filmsmvvm.data.model.toDomainModel
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository

class FilmsListRepositoryImpl(
    private val filmsService: FilmsService
) : FilmsListRepository, BaseRepository {
    override fun getFilmsList(): Single<FilmsListDomainModel> {
        return filmsService
            .getFilmsList()
            .map {
                it.toDataModel()
            }
            .map {//TODO: caching
                it.toDomainModel()
            }

    }
}