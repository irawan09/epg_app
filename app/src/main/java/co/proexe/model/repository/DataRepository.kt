package co.proexe.model.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.proexe.model.data.TvProgramme
import co.proexe.model.data.TvProgrammeCategory
import co.proexe.di.ServiceProvider
import com.google.gson.JsonNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val serviceProvider: ServiceProvider) {

    private var dataResponseLiveData: MutableLiveData<List<TvProgramme>>? = null
    private var remoteDataArray: ArrayList<TvProgramme> = ArrayList()

    init {
        dataResponseLiveData = MutableLiveData<List<TvProgramme>>()
        loadAllData()
    }

    private fun loadAllData() {
        val service = serviceProvider.createService()
        CoroutineScope(Dispatchers.IO).async(Dispatchers.Main) {
            val response = service.getAllData()
            if (response.isSuccessful) {
                val data = response.body()

                if (data != null) {
                    for (i in 0 until data.count()) {
                        val id: Int = data[i].id ?: "N/A".toInt()
                        val title = data[i].title ?: "N/A"
                        val imageUrl = data[i].imageUrl ?: "N/A"
                        val type = data[i].type ?: "N/A"
                        val category = data[i].category ?: "N/A"
                        val isFavourite = data[i].isFavourite ?: "N/A".toBoolean()
                        val startTime = data[i].startTime ?: "N/A"
                        val endTime = data[i].endTime ?: "N/A"
                        val progressPercent = data[i].progressPercent ?: "N/A".toInt()

                        val remoteData = TvProgramme(
                            id, title, imageUrl, type,
                            category as TvProgrammeCategory, isFavourite,
                            startTime, endTime, progressPercent
                        )

                        remoteDataArray.add(remoteData)
                        dataResponseLiveData?.postValue(remoteDataArray)
                    }

                } else {
                    Log.e("Data Empty", JsonNull.INSTANCE.toString())
                }
            } else {
                Log.e("Network Status", "Retrofit Error ${response.code()}")
            }
        }
    }

    fun getDataResponseLiveData(): LiveData<List<TvProgramme>>? {
        return dataResponseLiveData
    }


}