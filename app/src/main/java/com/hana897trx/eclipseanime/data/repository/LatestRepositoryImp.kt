package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import javax.inject.Inject

class LatestRepositoryImp @Inject constructor(
   private val latestRemoteDataSource: LatestRemoteDataSource
): LatestRepository {
   override suspend fun getLatest(networkSource: NetworkSource): List<LatestM> {
      return when (networkSource) {
         NetworkSource.REMOTE -> {
            latestRemoteDataSource.getLatest()
         }
         NetworkSource.LOCAL -> {
            emptyList()
         }
      }
   }
}