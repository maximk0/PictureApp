package com.example.pictureapp.data.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pictureapp.data.mapper.PhotoMapper
import com.example.pictureapp.domain.model.Photo
import javax.inject.Inject
import kotlin.random.Random

class RandomPhotosDataSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, Photo>() {

    private val mapper = PhotoMapper()

    init {
        Log.d("FAILTAG", "RandomPhotosDataSource init")
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int =
        Random.nextInt(FIRST_PAGE, LAST_PAGE)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        Log.d("FAILTAG", "load: $params")
        val page = Random.nextInt(Random.nextInt(FIRST_PAGE, LAST_PAGE))
        return kotlin.runCatching {
            apiService.getRandomPhotos(page).map { mapper.mapDtoModelToEntity(it) }
        }.fold(
            onSuccess = {
                Log.d("FAILTAG", "Characters success: $it")
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = {
                Log.d("FAILTAG", "Characters fail: $it")
                LoadResult.Error(it)
            })
    }

    private companion object {
        private const val FIRST_PAGE = 1
        private const val LAST_PAGE = 34
    }

}
