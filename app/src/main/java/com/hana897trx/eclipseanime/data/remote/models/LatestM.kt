package com.hana897trx.eclipseanime.data.remote.models

import android.os.Parcelable
import com.google.firebase.firestore.DocumentSnapshot
import com.hana897trx.eclipseanime.utils.DefaultValues.EMPTY
import com.hana897trx.eclipseanime.utils.DefaultValues.ZERO
import kotlinx.parcelize.Parcelize

@Parcelize
data class LatestM (
    val title: String = EMPTY,
    val subTitle: String = EMPTY,
    val description: String = EMPTY,
    val coverUrl: String = EMPTY,
    val episodes: Int = ZERO,
    val genre: String = EMPTY,
    val updated: String = EMPTY
    ) : Parcelable

fun List<DocumentSnapshot>.toMapLatest() = map {
    LatestM(
        title = it["title"].toString(),
        subTitle = it["subTitle"].toString(),
        description = it["description"].toString(),
        coverUrl = it["coverUrl"].toString(),
        episodes = it["episodes"].toString().toInt(),
        genre = it["genre"].toString(),
        updated = it["updated"].toString()
    )
}