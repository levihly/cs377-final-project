package com.nau.releasefinder.data.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nau.releasefinder.data.database.converters.ListStringConverter
import kotlinx.parcelize.Parcelize

// create a room entity
@Entity(tableName = "releaseTable")
// make parcelable
@Parcelize
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
    val resource_url: String,

    // use a type converter to handle storing a list in Room
    @TypeConverters(ListStringConverter::class)
    val format: List<String>
) : Parcelable