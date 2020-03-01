package ru.romananchugov.filmsmvvm.view_model

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

    fun saveSubscribe(action: () -> Disposable) {
        compositeDisposable.add(action())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}