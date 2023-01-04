package com.example.movirapp.data.storrage.room

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movirapp.data.storrage.TypeConvertor
import com.example.movirapp.data.storrage.models.MovieStorage


@androidx.room.Database(entities = [MovieStorage::class], version = 1, exportSchema = false)
@TypeConverters(TypeConvertor::class)

abstract class Database : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: Database? = null
        private val LOCK = Any()
        private const val DB_NAME = "movie_item.db"

        fun getInstance(application: Application): Database {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    Database::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}