package ru.romananchugov.filmsmvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "updateTime")
data class FilmsUpdateTimeDBModel(
    @PrimaryKey
    val id: Int = 1,
    val lastUpdateTimeMillis: Long
)