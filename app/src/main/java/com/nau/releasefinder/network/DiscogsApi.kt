package com.nau.releasefinder.network


import com.nau.releasefinder.network.model.ReleaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscogsApi {

    @GET("releases/")
    suspend fun getReleaseById(@Path("release_id") releaseId: String, @Query("curr_abbr") currencyAbbreviation: String? = null) : ReleaseResponse
}