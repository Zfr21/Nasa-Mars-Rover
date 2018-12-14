package com.celaloglu.zafer.nasa.ui.photos

import android.accounts.NetworkErrorException
import com.celaloglu.zafer.nasa.api.response.Photo
import com.celaloglu.zafer.nasa.api.response.Photos
import com.celaloglu.zafer.nasa.api.service.NasaService
import com.celaloglu.zafer.nasa.repository.PhotosRepository
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class PhotosViewModelTest {

    private lateinit var photosViewModel: PhotosViewModel
    private lateinit var repository: PhotosRepository

    @Mock
    lateinit var view: PhotosContract.Activity
    @Mock
    lateinit var nasaService: NasaService

    @Before
    @Throws
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> Schedulers.trampoline() }
        MockitoAnnotations.initMocks(this)
        repository = PhotosRepository(nasaService)
        photosViewModel = PhotosViewModel(repository)
        photosViewModel.attachView(view = view)
    }

    @Test
    fun should_call_set_adapter() {
        val photos = Photos(emptyList())
        `when`(repository.getPhotos()).thenReturn(Single.just(photos))

        photosViewModel.getPhotos()

        verify(view, times(1)).showProgressBar()
        verify(view, times(1)).hideProgressBar()
        verify(view, times(1)).setAdapter(photos = photos)
    }

    @Test
    fun should_not_call_set_adapter() {
        val photos = Photos(emptyList())
        `when`(repository.getPhotos()).thenReturn(Single.error(NetworkErrorException()))

        photosViewModel.getPhotos()

        verify(view, never()).setAdapter(photos = photos)
    }

    @Test
    fun should_dismiss_progress_dialog_and_show_toast_message() {
        `when`(repository.getPhotos()).thenReturn(Single.error(NetworkErrorException()))

        photosViewModel.getPhotos()

        verify(view, times(1)).hideProgressBar()
        verify(view, times(1)).showErrorMessage()
    }

    @Test
    fun should_open_photo_activity() {
        val photo = Mockito.mock(Photo::class.java)

        photosViewModel.onPhotoClick(photo)

        verify(view).openPhotoActivity(photo)
    }
}
