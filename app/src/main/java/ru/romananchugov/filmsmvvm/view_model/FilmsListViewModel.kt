package ru.romananchugov.filmsmvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.romananchugov.filmsmvvm.domain.use_case.FilmsListUseCase
import ru.romananchugov.filmsmvvm.model.FilmsListPresentationModel
import ru.romananchugov.filmsmvvm.model.ext.toPresentationModel
import timber.log.Timber

class FilmsListViewModel(
    private val useCase: FilmsListUseCase
) : BaseViewModel() {

    private val _filmsListLiveData: MutableLiveData<FilmsListPresentationModel> = MutableLiveData()
    val filmsListLiveData: LiveData<FilmsListPresentationModel>
        get() = _filmsListLiveData

    private val _isError: MutableLiveData<Boolean?> = MutableLiveData()
    val isError: LiveData<Boolean?>
        get() = _isError

    private val _isLoading: MutableLiveData<Boolean?> = MutableLiveData()
    val isLoading: LiveData<Boolean?>
        get() = _isLoading

    override fun init() = saveSubscribe {
        useCase.getFilmsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _isLoading.value = true
            }
            .doFinally {
                _isLoading.value = null
            }
            .subscribe(
                {
                    _filmsListLiveData.value = it.toPresentationModel()
                },
                {
                    Timber.tag("LOL").i("Error: $it")
                    _isError.value = true
                }
            )

    }
}