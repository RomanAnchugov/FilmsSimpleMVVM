package ru.romananchugov.filmsmvvm.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_films_list.*
import org.koin.android.ext.android.inject
import ru.romananchugov.filmsmvvm.R
import ru.romananchugov.filmsmvvm.ui.adapter.FilmsListAdapter
import ru.romananchugov.filmsmvvm.view_model.FilmsListViewModel

class FilmsListFragment : BaseFragment() {

    private val viewModel: FilmsListViewModel by inject()
    private val adapter = FilmsListAdapter(viewModel::onListItemClick)

    override val layoutResId: Int = R.layout.fragment_films_list

    override fun initView(view: View) {
        val recycler = films_list_rv
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.filmsListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.filmsList)
        })

        viewModel.navigationToDescription.observe(
            viewLifecycleOwner, Observer {
                it?.let {
                    val direction =
                        FilmsListFragmentDirections.actionFilmsListFragmentToFilmDetailsFragment(it)
                    findNavController().navigate(direction)
                }
            }
        )
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }
}