package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.latest.LatestRemoteDataSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LatestRepositoryImp @Inject constructor(
   private val latestRemoteDataSource: LatestRemoteDataSource
): LatestRepository {
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
}