package com.example.pictureapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.domain.usecase.GetRandomPhotosUseCase
import com.example.pictureapp.domain.usecase.LikePhotoUseCase
import com.example.pictureapp.domain.usecase.UnlikePhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomPhotosUseCase: GetRandomPhotosUseCase,
    private val likePhotoUseCase: LikePhotoUseCase,
    private val unLikePhotoUseCase: UnlikePhotoUseCase,
) : ViewModel() {

     fun randomPhotos() = getRandomPhotosUseCase().cachedIn(viewModelScope)

    fun likePhoto(photo: Photo) {
        viewModelScope.launch {
            likePhotoUseCase(photo)
        }
    }

    fun unLikePhoto(photo: Photo) = unLikePhotoUseCase(photo)

}
