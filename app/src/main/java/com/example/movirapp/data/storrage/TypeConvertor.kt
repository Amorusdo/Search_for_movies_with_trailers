package com.example.movirapp.data.storrage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConvertor {

    @TypeConverter
    fun toStorage(genreIds: List<Int>?): String? {
        if (genreIds == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Int>?>() {}.type
        return gson.toJson(genreIds, type)
    }

    @TypeConverter
    fun fromStorage(genreIds: String?): List<Int>? {
        if (genreIds == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Int>?>() {}.type
        return gson.fromJson(genreIds, type)
    }
}