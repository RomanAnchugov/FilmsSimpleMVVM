package ru.romananchugov.filmsmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*
import ru.romananchugov.filmsmvvm.R
import ru.romananchugov.filmsmvvm.model.FilmItemPresentationModel

class FilmsListAdapter(
    private val itemClickListener: ((item: FilmItemPresentationModel) -> Unit)?
) :
    ListAdapter<FilmItemPresentationModel, FilmsListAdapter.ViewHolder>(FilmsListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_film,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        private val filmImage = viewItem.film_image_iv
        private val filmTitle = viewItem.film_title_tv
        private val filmVoteAverage = viewItem.film_vote_average_tv

        fun bind(item: FilmItemPresentationModel) {
            viewItem.setOnClickListener {
                itemClickListener?.invoke(item)
            }

            Glide
                .with(filmImage.context)
                .load(item.posterPath)
                .centerCrop()
                .into(filmImage)

            //TODO: rating color depend on number
            filmTitle.text = item.title
            filmVoteAverage.text = item.voteAverage.toString()
        }
    }

    class FilmsListDiffCallback : DiffUtil.ItemCallback<FilmItemPresentationModel>() {
        override fun areItemsTheSame(
            oldItem: FilmItemPresentationModel,
            newItem: FilmItemPresentationModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: FilmItemPresentationModel,
            newItem: FilmItemPresentationModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

    }
}