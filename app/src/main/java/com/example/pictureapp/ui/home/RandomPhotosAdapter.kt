package com.example.pictureapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.bumptech.glide.Glide
import com.example.pictureapp.R
import com.example.pictureapp.databinding.ItemPictureBinding
import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.ui.common.PhotosDiffUtilCallback
import com.example.pictureapp.ui.common.PhotosViewHolder

class RandomPhotosAdapter(
    private val onLikeClicked: (Photo) -> Unit,
    private val onDislikeClicked: (Photo) -> Unit,
) : PagingDataAdapter<Photo, PhotosViewHolder>(PhotosDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(
            ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val item = getItem(position)

        var isClickLike = item?.likeByUser ?: false

        /* change icon like/unlike */
        val changeLikeIcon: (Int) -> Unit = { idLikeImage ->
            holder.binding.likeBtn.setImageResource(idLikeImage)
        }

        if (item?.likeByUser == true) changeLikeIcon(R.drawable.ic_like)
        else changeLikeIcon(R.drawable.ic_unlike)


        with(holder.binding) {
            Glide.with(photoIV.context)
                .load(item?.url)
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_error)
                .into(photoIV)

            authorTV.text = item?.author

            likeBtn.setOnClickListener {
                isClickLike = !isClickLike

                if (isClickLike) {
                    changeLikeIcon(R.drawable.ic_like)
                    if (item?.likeByUser == false)
                        onLikeClicked(item)
                } else{
                    changeLikeIcon(R.drawable.ic_unlike)
                    if (item?.likeByUser == true)
                        onDislikeClicked(item)
                }

            }
        }
    }

}
