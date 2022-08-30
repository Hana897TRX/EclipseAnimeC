package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.local.models.LatestAnimeDB
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.data.remote.models.toLatestMDBSelected
import com.hana897trx.eclipseanime.data.repository.AnimeRepository
import com.hana897trx.eclipseanime.utils.DataSource
import com.hana897trx.eclipseanime.utils.ErrorCodes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSelectedAnime @Inject constructor(
    private val animeRepository: AnimeRepository
){
    operator fun invoke(latestM: LatestM) = flow<DataSource<LatestAnimeDB>> {
        emit(DataSource.Loading)
        try {
            val anime = animeRepository.getSelectedAnime()
            anime?.let {
                emit(DataSource.Success(it))
            } ?: emit(DataSource.Error(message = "", errorCode = ErrorCodes.NO_DATA_FOUNT))
        } catch (e: Exception) {
            emit(
                DataSource.Error(
                    message = e.message.orEmpty(),
                    errorCode = ErrorCodes.ERROR_NOT_RELATED
                )
            )
        }
    }.flowOn(Dispatchers.IO)
}