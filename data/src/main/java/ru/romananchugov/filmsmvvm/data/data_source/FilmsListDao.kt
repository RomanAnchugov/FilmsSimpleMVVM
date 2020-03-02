package ru.romananchugov.filmsmvvm.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.romananchugov.filmsmvvm.data.model.FilmItemDataModel

@Dao
public interface FilmsListDao {

    @Query("SELECT * FROM films")
    fun getCached(): List<FilmItemDataModel>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setCached(item: FilmItemDataModel)
}