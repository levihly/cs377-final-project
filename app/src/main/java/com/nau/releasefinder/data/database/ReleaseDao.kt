package com.nau.releasefinder.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.nau.releasefinder.data.database.model.Release
import kotlinx.coroutines.flow.Flow

// declare a dao
@Dao
interface ReleaseDao {
    // insert a release
    @Insert
    suspend fun insertRelease(release: Release)

    // query the release with a select statement
    @Query("SELECT * FROM releaseTable")
    fun getRelease(): Flow<Release>

    // delete a release
    @Delete
    suspend fun deleteRelease(releaseToDelete: Release)
}