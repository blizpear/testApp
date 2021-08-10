package ru.cft.shift2021summer.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(
    includes = [
        CountryDatabaseModule::class,
        CountryNetworkModule::class,
        CountryRepositoryModule::class,
        UseCaseModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object ApplicationModule