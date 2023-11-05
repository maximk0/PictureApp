package com.example.pictureapp.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.pictureapp.R
import com.example.pictureapp.databinding.ItemPictureBinding
import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.ui.common.PhotosDiffUtilCallback
import com.example.pictureapp.ui.common.PhotosViewHolder

class FavoriteAdapter : ListAdapter<Photo, PhotosViewHolder>(PhotosDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(
            ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {

            likeBtn.setImageResource(R.drawable.ic_like)

            Glide.with(photoIV.context)
                .load(item?.url)
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_error)
                .into(photoIV)

            authorTV.text = item?.author
        }
    }

}
