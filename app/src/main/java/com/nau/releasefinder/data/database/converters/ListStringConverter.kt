package com.nau.releasefinder.data.database.converters

import androidx.room.TypeConverter

// type converter for handling the format list of the release
class ListStringConverter {
    // convert list to a string so Room can store it
    @TypeConverter
    fun fromList(list: List<String>?): String {
        return list?.joinToString("|") ?: ""
    }

    // converts the string back into a list when reading from the database
    @TypeConverter
    fun toList(data: String): List<String> {
        return if (data.isEmpty()) emptyList() else data.split("|")
    }
}