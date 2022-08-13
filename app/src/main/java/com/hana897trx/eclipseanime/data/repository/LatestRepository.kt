package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.Flow

interface LatestRepository {
   suspend fun getLatest(networkSource: NetworkSource) : Flow<DataSource<List<LatestM>>>
}