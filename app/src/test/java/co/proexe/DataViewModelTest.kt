package co.proexe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import co.proexe.api.DataService
import co.proexe.model.data.TvProgramme
import co.proexe.model.repository.DataRepository
import co.proexe.viewmodel.DataViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DataViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule : TestRule =  InstantTaskExecutorRule ()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var dataService :  DataService

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var apiDataObserver: Observer<List<TvProgramme>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<TvProgramme>())
                .`when`(dataService)
                .getAllData()

            val viewModel = DataViewModel(dataRepository)

            viewModel.getRemoteResponseLiveData()?.observeForever(apiDataObserver)

            verify(dataService).getAllData()
            viewModel.getRemoteResponseLiveData()?.removeObserver(apiDataObserver)
        }
    }


    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(dataService)
                .getAllData()
            val viewModel = DataViewModel(dataRepository)
            viewModel.getRemoteResponseLiveData()?.observeForever(apiDataObserver)
            verify(dataService).getAllData()
            verify(apiDataObserver).onChanged(
                Resource.error(RuntimeException(errorMessage).toString())
            )
            viewModel.getRemoteResponseLiveData()?.removeObserver(apiDataObserver)
        }
    }
}