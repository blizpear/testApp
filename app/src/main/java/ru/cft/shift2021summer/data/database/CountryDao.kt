package ru.cft.shift2021summer.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("SELECT * FROM CountryDataDb")
    fun getCountries(): LiveData<List<CountryDataDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(countries: List<CountryDataDb>)
}