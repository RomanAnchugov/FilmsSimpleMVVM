package ru.romananchugov.filmsmvvm.data.repository

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.data.BaseRepository
import ru.romananchugov.filmsmvvm.data.data_source.FilmsService
import ru.romananchugov.filmsmvvm.data.model.toDomainModel
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository
import timber.log.Timber

class FilmsListRepositoryImpl(
    private val filmsService: FilmsService
) : FilmsListRepository, BaseRepository {
    override fun getFilmsList(): Single<FilmsListDomainModel> {
        Timber.tag("LOL").i("Repos call")
        return filmsService.getFilmsList().map {
            Timber.tag("LOL").i("Service response $it")
            it.toDomainModel()
        }
    }
}