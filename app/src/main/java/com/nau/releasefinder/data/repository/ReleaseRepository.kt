package com.nau.releasefinder.data.repository

import com.nau.releasefinder.data.database.ReleaseDao
import com.nau.releasefinder.data.database.model.Release
import com.nau.releasefinder.network.RetrofitClient
import com.nau.releasefinder.network.model.ReleaseResponse

class ReleaseRepository(private val releaseDao: ReleaseDao) {
    // get a release by its catalog number
    suspend fun fetchRelease(catNo: String): ReleaseResponse {
        return RetrofitClient.apiService.getRelaseByCatNo(catNo)
    }

    // insert a release into the db
    suspend fun insertRelease(releaseToAdd: Release) {
        return releaseDao.insertRelease(releaseToAdd)
    }

    // delete a release from the db
    suspend fun deleteRelease(releaseToDelete: Release) {
        return releaseDao.deleteRelease(releaseToDelete)
    }
}