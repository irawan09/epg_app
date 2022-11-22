package co.proexe.api

import co.proexe.model.data.TvProgramme
import retrofit2.Response
import retrofit2.http.GET

interface DataService {

    @GET("/b/GG8C")
    suspend fun getAllData(): Response<List<TvProgramme>>
}