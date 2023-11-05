package com.example.pictureapp.ui.common

import androidx.recyclerview.widget.DiffUtil
import com.example.pictureapp.domain.model.Photo

class PhotosDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(
        oldItem: Photo, newItem: Photo
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Photo, newItem: Photo
    ): Boolean = oldItem == newItem

}
