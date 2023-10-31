package com.example.pictureapp.ui.home

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pictureapp.databinding.ItemPictureBinding
import com.example.pictureapp.domain.Photo

class PhotosAdapter(
    private val onClickPhoto: (Photo) -> Unit,
    private val onLikeClicked: (String) -> Unit,
    private val onDislikeClicked: (String) -> Unit
) : PagingDataAdapter<Photo, PhotosViewHolder>(UnsplashPhotosDiffUtilCallback()) {
    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        TODO("Not yet implemented")
    }


}

class PhotosViewHolder(val binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root)

class UnsplashPhotosDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(
        oldItem: Photo, newItem: Photo
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Photo, newItem: Photo
    ): Boolean = oldItem == newItem

}