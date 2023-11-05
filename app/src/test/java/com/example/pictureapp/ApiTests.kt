package com.example.pictureapp

import com.example.pictureapp.data.network.ApiService
import com.example.pictureapp.data.network.PhotoDto
import com.example.pictureapp.data.repository.NetworkPhotosRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiTests {

    @Test
    fun testGetRandomPhotosSuccess() {
        runBlocking {
            val api: ApiService = mock()

            Mockito.`when`(api.getRandomPhotos(1)).thenReturn(photoDtoList)

            val repository = NetworkPhotosRepositoryImpl(api)

            repository.randomPhotos(1)

            verify(api).getRandomPhotos(1)
        }
    }

    @Test(expected = Exception::class)
    fun testGetRandomPhotosError() {
        runBlocking {
            val api: ApiService = mock()

            Mockito.`when`(api.getRandomPhotos(1)).thenThrow(Exception())

            val repository = NetworkPhotosRepositoryImpl(api)

            repository.getRandomPhotos()
        }
    }

    private val photoDtoList = listOf(
        PhotoDto(
            id = "0",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/yC-Yzbqy7PY",
            downloadUrl = "https://picsum.photos/id/0/5000/3333"
        ),
        PhotoDto(
            id = "1",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/LNRyGwIJr5c",
            downloadUrl = "https://picsum.photos/id/1/5000/3333"
        ),
        PhotoDto(
            id = "2",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/N7XodRrbzS0",
            downloadUrl = "https://picsum.photos/id/2/5000/3333"
        ),
        PhotoDto(
            id = "3",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/Dl6jeyfihLk",
            downloadUrl = "https://picsum.photos/id/3/5000/3333"
        ),
        PhotoDto(
            id = "4",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/y83Je1OC6Wc",
            downloadUrl = "https://picsum.photos/id/4/5000/3333"
        ),
        PhotoDto(
            id = "5",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3334,
            url = "https://unsplash.com/photos/LF8gK8-HGSg",
            downloadUrl = "https://picsum.photos/id/5/5000/3334"
        ),
        PhotoDto(
            id = "6",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/tAKXap853rY",
            downloadUrl = "https://picsum.photos/id/6/5000/3333"
        ),
        PhotoDto(
            id = "7",
            author = "Alejandro Escamilla",
            width = 4728,
            height = 3168,
            url = "https://unsplash.com/photos/BbQLHCpVUqA",
            downloadUrl = "https://picsum.photos/id/7/4728/3168"
        ),
        PhotoDto(
            id = "8",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/xII7efH1G6o",
            downloadUrl = "https://picsum.photos/id/8/5000/3333"
        ),
        PhotoDto(
            id = "9",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3269,
            url = "https://unsplash.com/photos/ABDTiLqDhJA",
            downloadUrl = "https://picsum.photos/id/9/5000/3269"
        ),
        PhotoDto(
            id = "10",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/6J--NXulQCs",
            downloadUrl = "https://picsum.photos/id/10/2500/1667"
        ),
        PhotoDto(
            id = "11",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/Cm7oKel-X2Q",
            downloadUrl = "https://picsum.photos/id/11/2500/1667"
        ),
        PhotoDto(
            id = "12",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/I_9ILwtsl_k",
            downloadUrl = "https://picsum.photos/id/12/2500/1667"
        ),
        PhotoDto(
            id = "13",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/3MtiSMdnoCo",
            downloadUrl = "https://picsum.photos/id/13/2500/1667"
        ),
        PhotoDto(
            id = "14",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/IQ1kOQTJrOQ",
            downloadUrl = "https://picsum.photos/id/14/2500/1667"
        ),
        PhotoDto(
            id = "15",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/NYDo21ssGao",
            downloadUrl = "https://picsum.photos/id/15/2500/1667"
        ),
        PhotoDto(
            id = "16",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/gkT4FfgHO5o",
            downloadUrl = "https://picsum.photos/id/16/2500/1667"
        ),
        PhotoDto(
            id = "17",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/Ven2CV8IJ5A",
            downloadUrl = "https://picsum.photos/id/17/2500/1667"
        ),
        PhotoDto(
            id = "18",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/Ps2n0rShqaM",
            downloadUrl = "https://picsum.photos/id/18/2500/1667"
        ),
        PhotoDto(
            id = "19",
            author = "Paul Jarvis",
            width = 2500,
            height = 1667,
            url = "https://unsplash.com/photos/P7Lh0usGcuk",
            downloadUrl = "https://picsum.photos/id/19/2500/1667"
        ),
        PhotoDto(
            id = "20",
            author = "Aleks Dorohovich",
            width = 3670,
            height = 2462,
            url = "https://unsplash.com/photos/nJdwUHmaY8A",
            downloadUrl = "https://picsum.photos/id/20/3670/2462"
        ),
        PhotoDto(
            id = "21",
            author = "Alejandro Escamilla",
            width = 3008,
            height = 2008,
            url = "https://unsplash.com/photos/jVb0mSn0LbE",
            downloadUrl = "https://picsum.photos/id/21/3008/2008"
        ),
        PhotoDto(
            id = "22",
            author = "Alejandro Escamilla",
            width = 4434,
            height = 3729,
            url = "https://unsplash.com/photos/du_OrQAA4r0",
            downloadUrl = "https://picsum.photos/id/22/4434/3729"
        ),
        PhotoDto(
            id = "23",
            author = "Alejandro Escamilla",
            width = 3887,
            height = 4899,
            url = "https://unsplash.com/photos/8yqds_91OLw",
            downloadUrl = "https://picsum.photos/id/23/3887/4899"
        ),
        PhotoDto(
            id = "24",
            author = "Alejandro Escamilla",
            width = 4855,
            height = 1803,
            url = "https://unsplash.com/photos/cZhUxIQjILg",
            downloadUrl = "https://picsum.photos/id/24/4855/1803"
        ),
        PhotoDto(
            id = "25",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/Iuq0EL4EINY",
            downloadUrl = "https://picsum.photos/id/25/5000/3333"
        ),
        PhotoDto(
            id = "26",
            author = "Vadim Sherbakov",
            width = 4209,
            height = 2769,
            url = "https://unsplash.com/photos/tCICLJ5ktBE",
            downloadUrl = "https://picsum.photos/id/26/4209/2769"
        ),
        PhotoDto(
            id = "27",
            author = "Yoni Kaplan-Nadel",
            width = 3264,
            height = 1836,
            url = "https://unsplash.com/photos/iJnZwLBOB1I",
            downloadUrl = "https://picsum.photos/id/27/3264/1836"
        ),
        PhotoDto(
            id = "28",
            author = "Jerry Adney",
            width = 4928,
            height = 3264,
            url = "https://unsplash.com/photos/_WiFMBRT7Aw",
            downloadUrl = "https://picsum.photos/id/28/4928/3264"
        ),
        PhotoDto(
            id = "29",
            author = "Go Wild",
            width = 4000,
            height = 2670,
            url = "https://unsplash.com/photos/V0yAek6BgGk",
            downloadUrl = "https://picsum.photos/id/29/4000/2670"
        )
    )

}
