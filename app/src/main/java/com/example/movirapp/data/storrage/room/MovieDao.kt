package com.example.movirapp.data.storrage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movirapp.data.storrage.models.MovieStorage


@Dao
interface MovieDao {

    @Query("SELECT * FROM movieTable")
    fun getStorageMovies(): List<MovieStorage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovie(movie: MovieStorage)

    @Query("DELETE FROM movieTable WHERE movieId =:movieId")
    fun deleteMoviesFromStorage(movieId: Int)
}