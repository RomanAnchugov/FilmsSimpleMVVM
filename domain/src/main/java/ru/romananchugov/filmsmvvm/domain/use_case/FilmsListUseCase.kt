package ru.romananchugov.filmsmvvm.domain.use_case

import io.reactivex.rxjava3.core.Single
import ru.romananchugov.filmsmvvm.domain.model.FilmsListDomainModel
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository

interface FilmsListUseCase :
    BaseUseCase {
    fun getFilmsList(): Single<FilmsListDomainModel>
}

class FilmsListUseCaseImpl(
    private val repository: FilmsListRepository
) : FilmsListUseCase {
    override fun getFilmsList(): Single<FilmsListDomainModel> {
        return repository.getFilmsList()
    }
}