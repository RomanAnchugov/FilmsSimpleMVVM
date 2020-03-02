package ru.romananchugov.filmsmvvm.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.romananchugov.filmsmvvm.data.model.FilmItemDataModel
import ru.romananchugov.filmsmvvm.data.model.FilmsUpdateTimeDBModel

@Database(
    entities = [FilmItemDataModel::class, FilmsUpdateTimeDBModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun filmsDao(): FilmsListDao

    abstract fun updateTimeDao(): UpdateTimeDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null
        private const val DB_NAME = "FilmsListMVVM.db"

        fun getInstance(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}