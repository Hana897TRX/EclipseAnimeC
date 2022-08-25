package com.hana897trx.eclipseanime.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hana897trx.eclipseanime.utils.DefaultValues

@Entity(tableName = "anime")
data class LatestAnimeDB(
    @PrimaryKey val uid: Long = 0L,
    val title: String = DefaultValues.EMPTY,
    @ColumnInfo(name = "sub_title") val subTitle: String = DefaultValues.EMPTY,
    val description: String = DefaultValues.EMPTY,
    @ColumnInfo(name = "cover_url") val coverUrl: String = DefaultValues.EMPTY,
    val episodes: Int = DefaultValues.ZERO,
    val genre: String = DefaultValues.EMPTY,
    val updated: String = DefaultValues.EMPTY,
    val selected: Boolean = false
)