package com.nau.releasefinder.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nau.releasefinder.data.database.model.Release

// define the room database and its contents
@Database(entities = [Release::class], version = 1, exportSchema = false)
abstract class ReleaseDatabase : RoomDatabase(){
    // abstract function to get the DAO
    abstract fun releaseDao() : ReleaseDao

    // create a db instance, but ensure it's singleton
    companion object {
        private var releaseDatabase: ReleaseDatabase? = null

        fun getInstance(context: Context): ReleaseDatabase {
            return releaseDatabase ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReleaseDatabase::class.java,
                    "release_database"
                ).build()
                releaseDatabase = instance
                instance
            }
        }
    }
}