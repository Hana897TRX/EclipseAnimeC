package com.hana897trx.eclipseanime.data.remote.latest

import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.Flow

interface LatestRemoteDataSource{
    suspend fun getLatest() : Flow<DataSource<List<LatestM>>>
}