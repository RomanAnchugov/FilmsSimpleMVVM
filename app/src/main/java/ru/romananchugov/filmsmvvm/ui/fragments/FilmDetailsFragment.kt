package ru.romananchugov.filmsmvvm.ui.fragments

import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_film_details.*
import ru.romananchugov.filmsmvvm.R

class FilmDetailsFragment : BaseFragment() {

    private val args: FilmDetailsFragmentArgs by navArgs()

    override val layoutResId: Int = R.layout.fragment_film_details

    override fun initView(view: View) {
        film_details_overview_tv.text = args.filmItem.overview
        film_details_title_tv.text = args.filmItem.title
        Glide.with(film_details_image_iv.context).load(args.filmItem.backdropPath)
            .centerCrop()
            .into(film_details_image_iv)
    }
}
