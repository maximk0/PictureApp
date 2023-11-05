package com.example.pictureapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pictureapp.data.network.ApiService
import com.example.pictureapp.data.network.RandomPhotosDataSource
import com.example.pictureapp.domain.model.Photo
import com.example.pictureapp.domain.repository.NetworkPhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NetworkPhotosRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): NetworkPhotosRepository {


    suspend fun randomPhotos(page: Int) =
        apiService.getRandomPhotos(page)

    override fun getRandomPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { RandomPhotosDataSource(apiService) }
        ).flow
    }

}
