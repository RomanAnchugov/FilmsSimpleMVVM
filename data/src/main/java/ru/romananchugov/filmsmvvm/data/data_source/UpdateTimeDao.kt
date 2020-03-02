package ru.romananchugov.filmsmvvm.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.romananchugov.filmsmvvm.data.model.FilmsUpdateTimeDBModel

@Dao
interface UpdateTimeDao {
    @Query("SELECT * FROM updateTime")
    fun getUpdateTime(): FilmsUpdateTimeDBModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setUpdateTime(filmsUpdateTimeDataModel: FilmsUpdateTimeDBModel)
}