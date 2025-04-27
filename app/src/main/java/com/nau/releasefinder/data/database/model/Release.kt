package com.nau.releasefinder.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// create a room entity
@Entity(tableName = "releaseTable")
// create data class
data class Release(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val thumb: String?,
    val country: String?,
    val year: String?,
    val catno: String,
    val type: String?,
    val uri: String,
    val resource_url: String
)