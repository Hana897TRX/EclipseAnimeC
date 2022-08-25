package com.hana897trx.eclipseanime.data.repository

import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB
import com.hana897trx.eclipseanime.utils.NetworkSource
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
   suspend fun getLatest(networkSource: NetworkSource) : Flow<DataSource<List<LatestM>>>
   suspend fun saveAnime(latestAnimeDB: LatestAnimeDB) : Long
   suspend fun getSelectedAnime() : LatestAnimeDB?
}