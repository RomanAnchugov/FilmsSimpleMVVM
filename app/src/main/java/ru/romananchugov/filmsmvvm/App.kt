package ru.romananchugov.filmsmvvm

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.romananchugov.filmsmvvm.data.dataModule
import ru.romananchugov.filmsmvvm.domain.domainModule
import ru.romananchugov.filmsmvvm.di.presentationModule
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }
}