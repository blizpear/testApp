package ru.cft.shift2021summer.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.cft.shift2021summer.data.database.CountryDatabase
import ru.cft.shift2021summer.data.network.CountryApiService
import ru.cft.shift2021summer.data.repository.CountryRepositoryImpl
import ru.cft.shift2021summer.domain.repository.CountryRepository
import javax.inject.Singleton

@Module(includes = [CountryRepositoryModule.RepositoryBind::class, CountryDatabaseModule::class,CountryNetworkModule::class])
@InstallIn(SingletonComponent::class)
object CountryRepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        countryDatabase: CountryDatabase,
        countryDataNetwork: CountryApiService
    ) : CountryRepositoryImpl = CountryRepositoryImpl(countryDatabase, countryDataNetwork)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryBind{
        @Binds
        fun bindRepository(impl: CountryRepositoryImpl): CountryRepository
    }
}