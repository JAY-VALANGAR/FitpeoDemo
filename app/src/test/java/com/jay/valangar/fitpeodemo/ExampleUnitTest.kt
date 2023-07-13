package com.jay.valangar.fitpeodemo

import org.junit.Test

import org.junit.Assert.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jay.valangar.fitpeodemo.data.model.TopicPhoto
import com.jay.valangar.fitpeodemo.repository.TopicPhotoRepository
import com.jay.valangar.fitpeodemo.viewmodel.TopicPhotosMainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    // Executes each task synchronously using Architecture Components
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Sets the main coroutine dispatcher to a TestCoroutineDispatcher
    @ExperimentalCoroutinesApi
    @get:Rule
//    var mainCoroutineRule = TestCoroutineRule()

    // Mock the repository
    @Mock
    lateinit var mockRepository: TopicPhotoRepository

    // The ViewModel instance to be tested
    private lateinit var viewModel: TopicPhotosMainViewModel

    // Test data
    private val testPhotos = listOf(
        TopicPhoto(1, 1, "Photo 1", "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952"),
        TopicPhoto(2, 2, "Photo 2", "https://via.placeholder.com/600/771796", "https://via.placeholder.com/150/771796")
    )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = TopicPhotosMainViewModel(mockRepository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
//        mainCoroutineRule.cleanupTestCoroutines()
    }

//    @Test
//    fun `fetchPhotos should update LiveData with the list of topic photos`() = mainCoroutineRule.runBlockingTest {
//        // Mock the repository's getPhotos function to return testPhotos
////        Mockito.`when`(mockRepository.getPhotos().get(0).url).thenReturn(testPhotos)
//
//        // Call fetchPhotos
//        viewModel.fetchPhotos()
//
//        // Assert that the LiveData is updated with the testPhotos
//        assertEquals(viewModel.photosLiveData.value, testPhotos)
//    }
}