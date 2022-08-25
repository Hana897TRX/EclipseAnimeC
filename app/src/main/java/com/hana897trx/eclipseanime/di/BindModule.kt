package com.hana897trx.eclipseanime.di

import com.hana897trx.eclipseanime.data.local.latest.AnimeLocalDataSource
import com.hana897trx.eclipseanime.data.local.latest.AnimeLocalDataSourceImp
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSource
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSourceImp
import com.hana897trx.eclipseanime.data.repository.AnimeRepository
import com.hana897trx.eclipseanime.data.repository.AnimeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    abstract fun provideRepositoryLatest(
        imp: AnimeRepositoryImp
    ) : AnimeRepository

    @Binds
    abstract fun provideRemoteLatestDataSource(
        imp: LatestRemoteDataSourceImp
    ) : LatestRemoteDataSource

    @Binds
    abstract fun provideLocalAnimeDataSource(
        imp: AnimeLocalDataSourceImp
    ) : AnimeLocalDataSource
}