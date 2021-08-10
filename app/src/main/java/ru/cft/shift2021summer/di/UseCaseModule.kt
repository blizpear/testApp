package ru.cft.shift2021summer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.cft.shift2021summer.domain.repository.CountryRepository
import ru.cft.shift2021summer.domain.usecase.GetCountryUseCase
import ru.cft.shift2021summer.domain.usecase.RefreshCountryUseCase
import javax.inject.Singleton

@Module(includes = [CountryRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCountryUseCase(repo: CountryRepository): GetCountryUseCase =
        GetCountryUseCase(repo)

    @Provides
    @Singleton
    fun provideRefreshCountryUseCase(repo: CountryRepository): RefreshCountryUseCase =
        RefreshCountryUseCase(repo)
}