package com.example.pictureapp.domain.model

data class Photo(
    val id: String,
    val author: String,
    val url: String,
    val likeByUser: Boolean
)
