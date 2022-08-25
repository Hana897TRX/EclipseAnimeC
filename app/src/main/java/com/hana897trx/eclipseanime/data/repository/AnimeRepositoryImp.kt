package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.data.local.latest.AnimeLocalDataSource
import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB
import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AnimeRepositoryImp @Inject constructor(
   private val latestRemoteDataSource: LatestRemoteDataSource,
   private val animeLocalDataSource: AnimeLocalDataSource
): AnimeRepository {
   override suspend fun getLatest(networkSource: NetworkSource): Flow<DataSource<List<LatestM>>> {
      return when (networkSource) {
         NetworkSource.REMOTE -> {
            latestRemoteDataSource.getLatest()
         }
         NetworkSource.LOCAL -> {
            flowOf(DataSource.Success(emptyList()))
         }
      }
   }

   override suspend fun saveAnime(latestAnimeDB: LatestAnimeDB): Long =
      animeLocalDataSource.saveAnime(latestAnimeDB)

   override suspend fun getSelectedAnime(): LatestAnimeDB? =
      animeLocalDataSource.getSelected()
}