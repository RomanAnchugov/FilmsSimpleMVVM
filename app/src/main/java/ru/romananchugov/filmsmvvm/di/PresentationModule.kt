package ru.romananchugov.filmsmvvm.di

import org.koin.dsl.module
import ru.romananchugov.filmsmvvm.view_model.FilmsListViewModel

val presentationModule = module {
    single { FilmsListViewModel(get()) }
}