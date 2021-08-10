package ru.cft.shift2021summer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CountryDataDb::class],
    version = 1,
    exportSchema = false
)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
}
