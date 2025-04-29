package com.nau.releasefinder.network


import com.nau.releasefinder.network.model.ReleaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscogsApi {

    @GET("search?q=&key=tNuKEPkKfJZdNkwmjYoH&secret=wxMLPHyGzWkFPzDGEqleCvHkfRPDTRGT")
    suspend fun getReleaseByCatNo(@Query("query") query: String) : ReleaseResponse
}