package ru.cft.shift2021summer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CountryDataDb::class],
    version = 1,
    exportSchema = false
)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
}
