package com.hana897trx.eclipseanime.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB

@Dao
interface AnimeDAO {
    @Insert(onConflict = REPLACE)
    suspend fun saveAnime(latestAnimeDB: LatestAnimeDB) : Long

    @Query("SELECT * FROM anime WHERE selected = 1")
    suspend fun getSelectedAnime(): LatestAnimeDB?
}