package com.hana897trx.eclipseanime.data.local.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hana897trx.eclipseanime.data.local.dao.AnimeDAO
import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB

@Database(entities = [LatestAnimeDB::class], version = 1)
abstract class RoomConfig : RoomDatabase() {
    abstract fun animeDao(): AnimeDAO
}