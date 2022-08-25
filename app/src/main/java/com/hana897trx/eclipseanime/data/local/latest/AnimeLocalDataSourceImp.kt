package com.hana897trx.eclipseanime.data.local.latest

import com.hana897trx.eclipseanime.data.local.config.RoomConfig
import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import javax.inject.Inject

class AnimeLocalDataSourceImp @Inject constructor(
    private val roomConfig: RoomConfig
): AnimeLocalDataSource {
    override suspend fun saveAnime(latestAnimeDB: LatestAnimeDB): Long =
        roomConfig.animeDao().saveAnime(latestAnimeDB)

    override suspend fun getSelected(): LatestAnimeDB? =
        roomConfig.animeDao().getSelectedAnime()
}