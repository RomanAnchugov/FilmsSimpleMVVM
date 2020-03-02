package ru.romananchugov.filmsmvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.romananchugov.filmsmvvm.domain.use_case.FilmsListUseCase
import ru.romananchugov.filmsmvvm.model.FilmItemPresentationModel
import ru.romananchugov.filmsmvvm.model.FilmsListPresentationModel
import ru.romananchugov.filmsmvvm.model.toPresentationModel
import timber.log.Timber

class FilmsListViewModel(
    private val useCase: FilmsListUseCase
) : BaseViewModel() {

    companion object {
        private const val TAG = "FilmsListViewModel"
    }

    private val _filmsListLiveData: MutableLiveData<FilmsListPresentationModel> = MutableLiveData()
    val filmsListLiveData: LiveData<FilmsListPresentationModel>
        get() = _filmsListLiveData

    private val _isError: MutableLiveData<Boolean?> = MutableLiveData(null)
    val isError: LiveData<Boolean?>
        get() = _isError

    private val _isLoading: MutableLiveData<Boolean?> = MutableLiveData(null)
    val isLoading: LiveData<Boolean?>
        get() = _isLoading

    private val _navigationToDescription: MutableLiveData<FilmItemPresentationModel?> =
        MutableLiveData(null)
    val navigationToDescription: LiveData<FilmItemPresentationModel?>
        get() = _navigationToDescription

    init {
        loadData()
    }

    private fun loadData() = saveSubscribe {
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
                    Timber.tag(TAG).i("Error: $it")
                    _isError.value = true
                }
            )

    }

    fun onListItemClick(item: FilmItemPresentationModel) {
        _navigationToDescription.value = item
    }

    fun onPause() {
        _navigationToDescription.value = null
        _isError.value = null
        _isLoading.value = null
    }
}