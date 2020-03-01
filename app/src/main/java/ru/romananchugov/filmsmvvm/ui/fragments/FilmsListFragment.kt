package ru.romananchugov.filmsmvvm.ui.fragments

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_films_list.*
import org.koin.android.ext.android.inject
import ru.romananchugov.filmsmvvm.R
import ru.romananchugov.filmsmvvm.ui.adapter.FilmsListAdapter
import ru.romananchugov.filmsmvvm.view_model.FilmsListViewModel
import timber.log.Timber

class FilmsListFragment : BaseFragment() {

    private val viewModel: FilmsListViewModel by inject()
    private val adapter = FilmsListAdapter()

    override val layoutResId: Int = R.layout.fragment_films_list

    override fun initView(view: View) {
        viewModel.init()

        viewModel.filmsListLiveData.observe(this, Observer {
            Timber.tag("LOL").i("Hallo $it")
            adapter.submitList(it.filmsList)
        })

        val recycler = films_list_rv
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)

    }
}