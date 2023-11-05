package com.example.pictureapp.domain.repository

import androidx.paging.PagingData
import com.example.pictureapp.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface NetworkPhotosRepository {
    fun getRandomPhotos(): Flow<PagingData<Photo>>

}
