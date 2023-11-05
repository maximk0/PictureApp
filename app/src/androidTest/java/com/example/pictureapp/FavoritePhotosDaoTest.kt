package com.example.pictureapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.pictureapp.data.storage.AppDatabase
import com.example.pictureapp.data.storage.FavoritePhotoDao
import com.example.pictureapp.data.storage.FavoritePhotoDbModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before

class FavoritePhotosDaoTest {
    private lateinit var favoritePhotosDao: FavoritePhotoDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room
            .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        favoritePhotosDao = db.favoritePhotoDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testGetAll() {
        runBlocking {
            for (i in favoritesPhotos) {
                favoritePhotosDao.addPhoto(i)
            }
            val daoSize = favoritePhotosDao.getAllFavoritePhotos().first().size

            assertEquals(7, daoSize)
        }
    }

    @Test
    fun dbIsInitializedTest() {
        Assert.assertTrue(this::favoritePhotosDao.isInitialized)
    }

    @Test
    fun testDeleteAll() {
        runBlocking {
            for (i in favoritesPhotos) {
                favoritePhotosDao.addPhoto(i)
            }
            favoritePhotosDao.deletePhoto(favoritesPhotos[0].id)
            val daoSize = favoritePhotosDao.getAllFavoritePhotos().first().size

            assertEquals(6, daoSize)
        }
    }

    private val favoritesPhotos = listOf(
        FavoritePhotoDbModel(
            id = "123",
            author = "Mark Doda",
            url = " https://picsum.photos/id/123/4928/3264",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "642",
            author = "Kelly Sikkema",
            url = "https://picsum.photos/id/642/2365/1774",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "641",
            author = "Fré Sonneveld",
            url = "https://picsum.photos/id/641/2509/1673",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "645",
            author = "Thomas Lefebvre",
            url = "https://picsum.photos/id/645/2509/1673",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "648",
            author = "Ales Krivec",
            url = "https://picsum.photos/id/648/2517/1667",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "126",
            author = "Zugr",
            url = "https://picsum.photos/id/126/4272/2511",
            likeByUser = false
        ),
        FavoritePhotoDbModel(
            id = "827",
            author = "kazuend",
            url = "https://picsum.photos/id/827/3333/5000",
            likeByUser = false
        )
    )

}
