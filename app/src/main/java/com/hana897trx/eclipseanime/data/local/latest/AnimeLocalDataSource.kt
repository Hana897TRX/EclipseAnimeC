package com.hana897trx.eclipseanime.data.local.latest

import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB
import com.hana897trx.eclipseanime.data.remote.models.LatestM

interface AnimeLocalDataSource {
    suspend fun saveAnime(latestAnimeDB: LatestAnimeDB): Long
    suspend fun getSelected() : LatestAnimeDB?
}