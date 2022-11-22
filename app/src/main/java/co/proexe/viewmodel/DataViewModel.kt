package co.proexe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.proexe.model.data.TvProgramme
import co.proexe.model.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor (private val repository: DataRepository): ViewModel() {

    private var remoteResponseLiveData : LiveData<List<TvProgramme>>? = null
    val dataTest: LiveData<List<TvProgramme>>? = remoteResponseLiveData

    init {
        viewModelScope.launch {
            remoteResponseLiveData = repository.getDataResponseLiveData()
        }
    }

    fun getRemoteResponseLiveData() : LiveData<List<TvProgramme>>? {
        return remoteResponseLiveData
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("DataViewModel", "DataViewModel destroyed!")
    }
}