package ru.romananchugov.filmsmvvm.ui.fragments

import android.view.View
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import ru.romananchugov.filmsmvvm.R
import ru.romananchugov.filmsmvvm.view_model.FilmsListViewModel
import timber.log.Timber

class FilmsListFragment : BaseFragment() {
    private val viewModel: FilmsListViewModel by inject()

    override val layoutResId: Int = R.layout.fragment_films_list

    override fun initView(view: View) {
        viewModel.init()

        viewModel.filmsListLiveData.observe(this, Observer {
            Timber.tag("LOL").i("Hallo $it")
        })
    }
}