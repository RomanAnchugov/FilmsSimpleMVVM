package ru.romananchugov.filmsmvvm.domain

import org.koin.dsl.module
import ru.romananchugov.filmsmvvm.domain.use_case.FilmsListUseCase
import ru.romananchugov.filmsmvvm.domain.use_case.FilmsListUseCaseImpl

val domainModule = module {
    single { FilmsListUseCaseImpl(get()) as FilmsListUseCase }
}