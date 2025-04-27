package com.nau.releasefinder.data.database

import android.app.Application
import com.nau.releasefinder.data.repository.ReleaseRepository

class ReleaseApp : Application() {
    // create a repository
    lateinit var repository: ReleaseRepository
        private set

    // on creation
    override fun onCreate() {
        super.onCreate()

        // create a database
        val database = ReleaseDatabase.getInstance(this)
        // allow communication between the database and repository via a DAO
        repository = ReleaseRepository(
            releaseDao = database.releaseDao()
        )
    }
}