package ru.cft.shift2021summer.data.mapper

import ru.cft.shift2021summer.data.database.CountryDataDb
import ru.cft.shift2021summer.domain.model.CountryData

//object CountryMapper {
//
//    fun networkToDomain(countryNet: ru.cft.shift2021summer.data.network.CountryDataNetwork): CountryData {
//        return CountryData(
//            name = countryNet.name,
//            capital = countryNet.capital,
//            region = countryNet.region,
//            flag = countryNet.flag,
//            topLevelDomain = countryNet.topLevelDomain,
//            population = countryNet.population,
//            area = countryNet.area,
//            languages = countryNet.languages
//        )
//    }
//
//    fun databaseToDomain(countryDb: CountryDataDb): CountryData {
//        return CountryData(
//            name = countryDb.name,
//            capital = countryDb.capital,
//            region = countryDb.region,
//            flag = countryDb.flag,
//            topLevelDomain = countryDb.topLevelDomain,
//            population = countryDb.population,
//            area = countryDb.area,
//            languages = countryDb.languages
//        )
//
//    }
//
//    fun netToDatabase(countryNet: ru.cft.shift2021summer.data.network.CountryDataNetwork): CountryDataDb {
//        return CountryDataDb(
//            name = countryNet.name,
//            capital = countryNet.capital,
//            region = countryNet.region,
//            flag = countryNet.flag,
//            topLevelDomain = countryNet.topLevelDomain,
//            population = countryNet.population,
//            area = countryNet.area,
//            languages = countryNet.languages
//        )
//    }
//}

fun List<CountryDataDb>.dbAsDomainModel(): List<CountryData> {
    return map {
        CountryData(
            name = it.name,
            capital = it.capital,
            region = it.region,
            flag = it.flag,
            //topLevelDomain = it.topLevelDomain,
            population = it.population,
            area = it.area,
            //languages = it.languages
        )
    }
}


fun List<ru.cft.shift2021summer.data.network.CountryDataNetwork>.netAsDomainModel(): List<CountryData> {
    return map {
        CountryData(
            name = it.name,
            capital = it.capital,
            region = it.region,
            flag = it.flag,
            //topLevelDomain = it.topLevelDomain,
            population = it.population,
            area = it.area,
            //languages = it.languages
        )
    }
}

fun List<ru.cft.shift2021summer.data.network.CountryDataNetwork>.netAsDatabaseModel(): List<CountryDataDb> {
    return map {
        CountryDataDb(
            name = it.name,
            capital = it.capital,
            region = it.region,
            flag = it.flag,
            //topLevelDomain = it.topLevelDomain,
            population = it.population,
            area = it.area,
            //languages = it.languages
        )
    }
}