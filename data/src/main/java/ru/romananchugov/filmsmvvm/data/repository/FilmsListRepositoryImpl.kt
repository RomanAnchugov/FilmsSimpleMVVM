package ru.romananchugov.filmsmvvm.data.repository

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.data.BaseRepository
import ru.romananchugov.filmsmvvm.data.data_source.AppDataBase
import ru.romananchugov.filmsmvvm.data.data_source.FilmsService
import ru.romananchugov.filmsmvvm.data.model.FilmsListDataModel
import ru.romananchugov.filmsmvvm.data.model.FilmsUpdateTimeDBModel
import ru.romananchugov.filmsmvvm.data.model.toDataModel
import ru.romananchugov.filmsmvvm.data.model.toDomainModel
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository
import java.util.*
import java.util.concurrent.TimeUnit

class FilmsListRepositoryImpl(
    private val filmsService: FilmsService,
    private val appDataBase: AppDataBase
) : FilmsListRepository, BaseRepository {

    companion object {
        private const val CACHE_UPDATE_TIME_HOURS = 2
    }

    override fun getFilmsList(): Single<FilmsListDomainModel> {
        return Single.fromCallable {
            appDataBase.updateTimeDao().getUpdateTime()?.lastUpdateTimeMillis ?: -1L
        }
            .flatMap { lastUpdateTime ->
                val timeDiff =
                    TimeUnit.MILLISECONDS.toHours(Calendar.getInstance().timeInMillis - lastUpdateTime)

                if (lastUpdateTime == -1L || timeDiff > CACHE_UPDATE_TIME_HOURS) {
                    getDataFromNW()
                } else {
                    getDataFromDB()
                }
            }
            .map {
                it.toDomainModel()
            }
    }

    private fun getDataFromNW(): Single<FilmsListDataModel> = filmsService
        .getFilmsList()
        .map {
            val result = it.toDataModel()
            val timeUpdate = appDataBase.updateTimeDao().getUpdateTime()?.lastUpdateTimeMillis

            result.filmsList.forEach { filmItem ->
                appDataBase.filmsDao().setCached(filmItem)
            }
            val expectedTime = Calendar.getInstance().timeInMillis
            appDataBase.updateTimeDao()
                .setUpdateTime(FilmsUpdateTimeDBModel(lastUpdateTimeMillis = expectedTime))

            result
        }

    private fun getDataFromDB(): Single<FilmsListDataModel> =
        Single.fromCallable {
            appDataBase
                .filmsDao()
                .getCached()
        }.map {
            it?.let {
                FilmsListDataModel(it)
            }
        }
}