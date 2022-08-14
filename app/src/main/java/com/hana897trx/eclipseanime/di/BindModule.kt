package com.hana897trx.eclipseanime.di

import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSource
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSourceImp
import com.hana897trx.eclipseanime.data.repository.LatestRepository
import com.hana897trx.eclipseanime.data.repository.LatestRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    abstract fun provideRepositoryLatest(
        imp: LatestRepositoryImp
    ) : LatestRepository

    @Binds
    abstract fun provideRemoteLatestDataSource(
        imp: LatestRemoteDataSourceImp
    ) : LatestRemoteDataSource

}