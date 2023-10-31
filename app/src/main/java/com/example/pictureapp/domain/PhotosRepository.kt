package com.example.pictureapp.domain

interface PhotosRepository {
    fun getRandomPhotos(): List<Photo>

    fun getFavoritePhotos(): List<Photo>

    fun likePhoto(photo: Photo)

    fun unlikePhoto(photo: Photo)
}